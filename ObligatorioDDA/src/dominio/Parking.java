package dominio;

import dominio.Tendencias.Estable;
import dominio.Tendencias.Negativa;
import dominio.Tendencias.Positiva;
import dominio.Tendencias.Tendencia;
import dominio.Etiquetas.Etiqueta;
import Utilidades.Observable;
import Utilidades.Validable;
import excepciones.AnomaliaException;
import excepciones.EstadiaException;
import excepciones.ParkingException;
import excepciones.TipoVehiculoException;
import java.util.Random;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Parking extends Observable
        implements Validable {

    private String nombre;
    private String direccion;
    private List<Tarifa> tarifas = new ArrayList<>();
    private int capacidad;
    private int ocupacion;
    private List<Cochera> cocheras = new ArrayList<>();
    private List<Estadia> estadias = new ArrayList<>();
    private Queue<Integer> ingresosEgresos;
    private Tendencia tendenciaActual;

    public Parking(String nombre, String direccion, List<Tarifa> tarifa, List<Cochera> cocheras) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.tarifas = tarifa;
        this.cocheras = cocheras;
        this.capacidad = cocheras.size();
        this.ocupacion = 0;
        this.ingresosEgresos = new LinkedList<>();
        this.tendenciaActual = new Estable(1.0);
    }

    public Parking(String nombre) {
        this.nombre = nombre;

    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public List<Tarifa> getTarifa() {
        return tarifas;
    }

    public List<Cochera> getCocheras() {
        return cocheras;
    }

    public List<Estadia> getEstadias() {
        return estadias;
    }

    public double getFactorDemanda() {
        return tendenciaActual.getFactorDemanda();
    }

    public Tendencia getTendenciaActual() {
        return tendenciaActual;
    }

    public int getOcupacion() {
        return ocupacion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public int calcularCocherasOcupadas() {
        int resultado = 0;
        for (Cochera c : cocheras) {
            if (c.getOcupada()) {
                resultado++;
            }
        }
        return resultado;
    }

    public int calcularCocherasLibres() {
        return cocheras.size() - calcularCocherasOcupadas();
    }

//    public void ingresarVehiculo() {
//        ocupacion++;
//        actualizarTendencia(1);
//        
//    }

//    public void egresarVehiculo() {
//        ocupacion--;
//        actualizarTendencia(-1);
//    }

    private void actualizarTendencia(int cambio) {
       
        if (ingresosEgresos.size() >= 10) {
            ingresosEgresos.poll();
        }

        ingresosEgresos.offer(cambio);

        int sumaIngresosEgresos = ingresosEgresos.stream().mapToInt(Integer::intValue).sum();
        int diferenciaIngresosEgresos = sumaIngresosEgresos;
        System.out.println("sumaIngresosEgresos "+sumaIngresosEgresos);
        System.out.println("diferenciaIngresosEgresos "+ diferenciaIngresosEgresos);
        System.out.println("factor demanda " + tendenciaActual.getFactorDemanda());
        if (diferenciaIngresosEgresos <= 0.1 * capacidad) {
            tendenciaActual = new Estable(tendenciaActual.getFactorDemanda());
        } else if (sumaIngresosEgresos > 0) {
            tendenciaActual = new Positiva(tendenciaActual.getFactorDemanda());
        } else {
            tendenciaActual = new Negativa(tendenciaActual.getFactorDemanda());
        }

        tendenciaActual.actualizarFactorDemanda(ocupacion, capacidad, diferenciaIngresosEgresos);
        System.out.println("tendencia actual "+ tendenciaActual.getNombre());
    }

    //TODO: Las horas hay que manejarlas correctamente.
    public void ingresarVehiculo(String codCochera, Vehiculo v) throws EstadiaException, AnomaliaException {
        Cochera c = retornarCochera(codCochera);
        Random random = new Random();
        LocalDateTime horaEntrada = LocalDateTime.now();//LocalDateTime.of(LocalDate.now(), LocalTime.of(random.nextInt(12), random.nextInt(60), random.nextInt(60)));
        //LocalDateTime horaSalida = LocalDateTime.of(LocalDate.now(), LocalTime.of(random.nextInt(12) + 12, random.nextInt(60), random.nextInt(60)));
        Estadia estadia = new Estadia(horaEntrada, c, v);
        estadia.Validar();
        if (c.getOcupada()) {
            Anomalia unaAnomalia = new Anomalia("HOUDINI");
            unaAnomalia.Validar();
            estadia.setFechaSalida(null);
            estadia.setHoraEntrada(null);
            
            estadia.setAnomalias(unaAnomalia);
            estadias.add(estadia); //Lo puse para mostrar HOUDINI
        } else {
            actualizarTendencia(1);
            ocupacion++;
            c.setOcupada(true);
            estadia.setFactorDemandaIngreso(tendenciaActual.getFactorDemanda());
            estadias.add(estadia);

            System.out.println("tendenciaActual ingreso!!! "+ tendenciaActual.getFactorDemanda());
//            // Aumentar la cuenta corriente del propietario
//            Propietario propietario = v.getPropietario();
//            if (propietario != null) {
//                double valorEstadia = estadia.getValorEstadia();
//                propietario.aumentarSaldo(valorEstadia);
//            }
        }
    }

    private Cochera retornarCochera(String codCochera) {
        for (Cochera c : cocheras) {
            if (c.retornarCodigo().equals(codCochera)) {
                return c;
            }
        }
        return null;
    }

    public float totalMultas() {
        float total = 0;
        for (Estadia estadia : estadias) {
            total += estadia.totalMultas();
        }
        return total;
    }

    public double totalFacturado() {
        double total = 0;
        for (Estadia estadia : estadias) {
            total += estadia.getValorEstadia();
        }
        return total;
    }

    public void actualizarValorTipoVehiculo(String nuevoPrecio, int indexTipo) throws TipoVehiculoException, NumberFormatException {
        Tarifa unaTarifa = tarifas.get(indexTipo);
        unaTarifa.actualizarPrecio(nuevoPrecio);
        this.avisar(EventoTarifa.NUEVO_PRECIO);
    }

    public Map<String, Integer> contarCocherasEtiquetas() {
        Map<String, Integer> contadorEtiquetas = new HashMap<>();
        contadorEtiquetas.put("Discapacitado", 0);
        contadorEtiquetas.put("Electrico", 0);
        contadorEtiquetas.put("Empleado", 0);

        for (Cochera cochera : cocheras) {
            for (Etiqueta etiqueta : cochera.getEtiquetas()) {
                String nombreEtiqueta = etiqueta.getNombre();
                if (contadorEtiquetas.containsKey(nombreEtiqueta) && !cochera.getOcupada()) {
                    contadorEtiquetas.put(nombreEtiqueta, contadorEtiquetas.get(nombreEtiqueta) + 1);
                }
            }
        }

        return contadorEtiquetas;
    }

    public List<Estadia> estadiasConAnomalia() {
        List<Estadia> ret = new ArrayList<>();

        for (Estadia e : estadias) {
            if (!e.getAnomalias().isEmpty()) {
                ret.add(e);
            }
        }
        return ret;
    }

    public void egresarVehiculo(String codCochera, Vehiculo unVehiculo) throws EstadiaException, AnomaliaException {
        Cochera unaCochera = retornarCochera(codCochera);

        Random random = new Random();

        LocalDateTime horaEntrada = LocalDateTime.now();//LocalDateTime.of(LocalDate.now(), LocalTime.of(random.nextInt(12), random.nextInt(60), random.nextInt(60)));
        LocalDateTime horaSalida = horaEntrada.plus(30, ChronoUnit.MINUTES);//LocalDateTime.of(LocalDate.now(), LocalTime.of(random.nextInt(12) + 12, random.nextInt(60), random.nextInt(60)));
       

        Estadia estadia = obtenerEstadia(codCochera, unVehiculo); //Machea vehiculo y cochera en estadia

        if (!unaCochera.getOcupada()) { //Cochera libre
            estadiaMistery(horaEntrada, horaSalida, unaCochera, unVehiculo);

        } else if (estadia != null) { //Ingresa al if si existe una estadia para ese Vehiculo y Cochera
            ocupacion--;
            actualizarTendencia(-1);
            liberarEstadia(estadia, unVehiculo, unaCochera);
            estadia.setFactorDemandaIngreso(tendenciaActual.getFactorDemanda());
            System.out.println("tendenciaActual salida!!! "+ tendenciaActual.getFactorDemanda());
        } else {  //Existe estadia para esa cochera y no es para ese vehiculo       
            estadiaTransportador1(codCochera);
            estadiaTransportador2(horaEntrada, horaSalida, unaCochera, unVehiculo);

        }
    }

    private Estadia obtenerEstadia(String codCochera, Vehiculo vh) {
        for (Estadia unaEst : estadias) {
            if (unaEst.retornarCodCochera().equals(codCochera) && vh.getPatente().equals(unaEst.retornarPatenteVehiculo())) {
                return unaEst;
            }
        }
        return null;
    }

    private Estadia obtenerEstadiaSinVehiculo(String codCochera) {
        for (Estadia unaEst : estadias) {
            if (unaEst.retornarCodCochera().equals(codCochera)) {
                return unaEst;
            }
        }
        return null;
    }

    private void estadiaMistery(LocalDateTime horaEntrada, LocalDateTime horaSalida, Cochera unaCochera, Vehiculo unVehiculo) throws EstadiaException, AnomaliaException {
        Estadia estadiaNueva = new Estadia(horaEntrada,  unaCochera, unVehiculo);
        estadiaNueva.setFechaSalida(horaSalida);
        estadiaNueva.Validar();
        Anomalia unaAnomalia = new Anomalia("MISTERY");
        unaAnomalia.Validar();
        estadiaNueva.setAnomalias(unaAnomalia);
        estadias.add(estadiaNueva);
    }

    private void liberarEstadia(Estadia estadiaActualizar, Vehiculo unVehiculo, Cochera unaCochera) {
        Propietario propietario = unVehiculo.getPropietario();
        if (propietario != null) {
            double valorEstadia = estadiaActualizar.getValorEstadia();
            propietario.disminuirSaldo(valorEstadia);
        }
        unaCochera.setOcupada(false);
        estadias.remove(estadiaActualizar);
    }

    private void estadiaTransportador1(String codCochera) throws AnomaliaException {
        Estadia estadiaSinVh = obtenerEstadiaSinVehiculo(codCochera);
        if (estadiaSinVh != null) {
            Anomalia anomalia1 = new Anomalia("TRANSPORTADOR1");
            anomalia1.Validar();
            estadiaSinVh.setAnomalias(anomalia1);
        }

    }

    private void estadiaTransportador2(LocalDateTime horaEntrada, LocalDateTime horaSalida, Cochera unaCochera, Vehiculo unVehiculo) throws EstadiaException, AnomaliaException {
        Estadia estadiaN = new Estadia(horaEntrada,unaCochera, unVehiculo);
        estadiaN.setFechaSalida(horaSalida);
        estadiaN.Validar();
        Anomalia anomalia2 = new Anomalia("TRANSPORTADOR2");
        anomalia2.Validar();
        estadiaN.setAnomalias(anomalia2);
        estadiaN.setFechaSalida(horaSalida);
        estadias.add(estadiaN);
    }

    @Override
    public void Validar() throws ParkingException {
        validarNombre();
        validarDireccion();
        validarTarifas();
        validarCocheras();
    }

    private void validarNombre() throws ParkingException {
        if (nombre.isBlank()) {
            throw new ParkingException("El nombre no puede estar vacío.");
        }
    }

    private void validarDireccion() throws ParkingException {
        if (direccion.isBlank()) {
            throw new ParkingException("La dirección no puede estar vacía.");
        }
    }

    private void validarTarifas() throws ParkingException {
        if (tarifas == null) {
            throw new ParkingException("La lista de tarifas no puede ser nula.");
        }
    }

    private void validarCocheras() throws ParkingException {
        if (cocheras == null) {
            throw new ParkingException("La lista de cocheras no puede ser nula.");
        }
    }

}
