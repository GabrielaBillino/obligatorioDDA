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
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ThreadLocalRandom;

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

    public String nombreTendenciaActual() {
        return tendenciaActual.getNombre();
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

    private void actualizarTendencia() {
        double porcentajeDiferencia = diferenciaIngresoEgreso() / (double) capacidad;

        System.out.println("Ocupacion: " + ocupacion + ", Capacidad: " + capacidad);
        System.out.println("Diferencia Ingreso-Egreso: " + diferenciaIngresoEgreso());
        System.out.println("Porcentaje Diferencia: " + porcentajeDiferencia);

        if (porcentajeDiferencia <= 0.1 && diferenciaIngresoEgreso() > 0) {
            tendenciaActual = new Estable(tendenciaActual.getFactorDemanda());
        } else if (diferenciaIngresoEgreso() > 0 && porcentajeDiferencia > 0.1) {
            tendenciaActual = new Positiva(tendenciaActual.getFactorDemanda());
        } else if (diferenciaIngresoEgreso() < 0 && porcentajeDiferencia < 0.1) {
            tendenciaActual = new Negativa(tendenciaActual.getFactorDemanda());
        }
        tendenciaActual.actualizarFactorDemanda(ocupacion, capacidad, diferenciaIngresoEgreso());

    }

    private int diferenciaIngresoEgreso() {
        int ingresos = 0;
        int egresos = 0;
       
        LocalDateTime ahora = LocalDateTime.now();
        LocalDateTime hace10minutos = ahora.minusMinutes(10);

        for (Estadia e : estadias) {
             if (e.getHoraSalida() != null && e.getHoraSalida().isAfter(hace10minutos)) {
                egresos++;                               
            }else if (e.getHoraEntrada() != null && e.getHoraEntrada().isAfter(hace10minutos) && e.getHoraEntrada().isBefore(ahora)) {
                ingresos++;
            }      
        }      
        return ingresos - egresos;
    }

    public void ingresarVehiculo(String codCochera, Vehiculo v) throws EstadiaException, AnomaliaException {
        Cochera c = retornarCochera(codCochera);
        //Se crea estadia nueva para esa cochera y vehiculo.
        LocalDateTime horaEntrada = LocalDateTime.now();
        Estadia estadia = new Estadia(horaEntrada, c, v);
        estadia.Validar();
            
        System.out.println("Intentando ingresar vehiculo " + v.retornarPatente() + " en la cochera " + codCochera);
        if (c.getOcupada()) {
            System.out.println("Inconsistencia detectada para cochera: " + codCochera + ". Registrando anomalia HOUDINI.");
            Anomalia unaAnomalia = new Anomalia("HOUDINI");
            unaAnomalia.Validar();
            //Se obtiene la estadia que tiene a la cochera que se quiere ingresar.
            Estadia estadiaConCochera = obtenerEstadiaSinVehiculo(codCochera);
            if(estadiaConCochera != null){
                System.out.println("Se obtiene la estadia donde está la cochera ocupada");
                estadiaConCochera.setFechaSalida(null);
                estadiaConCochera.setHoraEntrada(null);
                estadiaConCochera.setAnomalias(unaAnomalia);  
                ocupacion--;
                //Se sigue el curso normal para esa cochera y vehiculo como indica el curso alternativo
                //del caso de uso
               cursoNormalIngresoVehiculo(c, v);     
            }           
        } else {
            cursoNormalIngresoVehiculo(c, v);
        }
    }
    
    private void cursoNormalIngresoVehiculo(Cochera cocheraEncontrada, Vehiculo v) throws EstadiaException{     
         //Se crea estadia nueva para esa cochera y vehiculo.
        LocalDateTime horaEntrada = LocalDateTime.now();
        Estadia estadia = new Estadia(horaEntrada, cocheraEncontrada, v);
        estadia.Validar();
        System.out.println("Se realiza ingreso del vehiculo " + v.retornarPatente() + " en la cochera " + cocheraEncontrada.retornarCodigo());
        cocheraEncontrada.setOcupada(true);
        estadia.setFactorDemandaIngreso(tendenciaActual.getFactorDemanda());
        estadias.add(estadia);
        ocupacion++;

        actualizarTendencia(); // Llamada al método para actualizar la tendencia con el cambio

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

        // Generar hora de salida aleatoria para simular el tiempo de estadía
        LocalDateTime horaEntrada = LocalDateTime.now();
        long randomMinutes = ThreadLocalRandom.current().nextLong(1, 30);
        LocalDateTime horaSalida = horaEntrada.plus(randomMinutes, ChronoUnit.MINUTES);

        Estadia estadia = obtenerEstadia(codCochera, unVehiculo);

        System.out.println("Intentando egresar vehiculo: " + unVehiculo.retornarPatente()+ " de la cochera: " + codCochera);

        if (!unaCochera.getOcupada()) { // Caso de cochera libre sin estadía activa
            System.out.println("Cochera " + codCochera + " esta libre. Registrando anomalia MISTERY.");
            estadiaMistery(horaEntrada, horaSalida, unaCochera, unVehiculo);
        } else if (estadia != null) { // Caso de estadía existente y válida
            System.out.println("Egresando vehiculo: " + unVehiculo.retornarPatente()+ " de la cochera: " + codCochera);
           
            liberarEstadia(estadia, unVehiculo, unaCochera, horaSalida);
            actualizarTendencia(); // Actualizar tendencia después de egreso
        } else { // Caso de inconsistencias (anomalías de tipo TRANSPORTADOR)
            System.out.println("Inconsistencia detectada para cochera: " + codCochera + ". Registrando anomalias TRANSPORTADOR.");
            estadiaTransportador1(codCochera);
            estadiaTransportador2(unVehiculo);
        }
    }

    private Estadia obtenerEstadia(String codCochera, Vehiculo vh) {
        for (Estadia unaEst : estadias) {
            if (unaEst.retornarCodCochera().equals(codCochera) && vh.retornarPatente().equals(unaEst.retornarPatenteVehiculo())) {
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
        Estadia estadiaNueva = new Estadia(horaEntrada, unaCochera, unVehiculo);
        estadiaNueva.setFechaSalida(horaSalida);
        estadiaNueva.Validar();
        Anomalia unaAnomalia = new Anomalia("MISTERY");
        unaAnomalia.Validar();
        estadiaNueva.setAnomalias(unaAnomalia);
        estadias.add(estadiaNueva);
    }

    private void liberarEstadia(Estadia estadiaActualizar, Vehiculo unVehiculo, Cochera unaCochera, LocalDateTime horaSalida) {
        Propietario propietario = unVehiculo.getPropietario();
        if (propietario != null) {
            double valorEstadia = estadiaActualizar.getValorEstadia();
            propietario.disminuirSaldo(valorEstadia);
        }
        estadiaActualizar.setFechaSalida(horaSalida);
        estadiaActualizar.setFactorDemandaIngreso(tendenciaActual.getFactorDemanda());
        unaCochera.setOcupada(false);
        ocupacion--;
    }

    private void estadiaTransportador1(String codCochera) throws AnomaliaException {
        Estadia estadiaSinVh = obtenerEstadiaSinVehiculo(codCochera);
        if (estadiaSinVh != null) {
            Anomalia anomalia1 = new Anomalia("TRANSPORTADOR1");
            anomalia1.Validar();
            estadiaSinVh.setAnomalias(anomalia1);
        }
    }

    private void estadiaTransportador2(Vehiculo unVehiculo) throws EstadiaException, AnomaliaException {
        Estadia estadiaN = buscarEstadiaPorVehiculo(unVehiculo);
        if (estadiaN != null) {
            Anomalia anomalia2 = new Anomalia("TRANSPORTADOR2");
            anomalia2.Validar();
            estadiaN.setAnomalias(anomalia2);
        }
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

    private Estadia buscarEstadiaPorVehiculo(Vehiculo unVehiculo) {
        for (Estadia e : estadias) {
            if (e.getVehiculo().retornarPatente().equals(unVehiculo.retornarPatente()) && e.getHoraSalida() == null) {
                return e;
            }
        }
        return null;
    }

}
