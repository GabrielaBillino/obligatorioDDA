package dominio;

import Utilidades.Observable;
import java.util.Random;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Parking extends Observable{

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

    public void ingresarVehiculo() {
        ocupacion++;
        actualizarTendencia(1);
    }

    public void egresarVehiculo() {
        ocupacion--;
        actualizarTendencia(-1);
    }

    private void actualizarTendencia(int cambio) {
        if (ingresosEgresos.size() >= 10) {
            ingresosEgresos.poll();
        }

        ingresosEgresos.offer(cambio);

        int sumaIngresosEgresos = ingresosEgresos.stream().mapToInt(Integer::intValue).sum();
        int diferenciaIngresosEgresos = Math.abs(sumaIngresosEgresos);

        if (diferenciaIngresosEgresos <= 0.1 * capacidad) {
            tendenciaActual = new Estable(tendenciaActual.getFactorDemanda());
        } else if (sumaIngresosEgresos > 0) {
            tendenciaActual = new Positiva(tendenciaActual.getFactorDemanda());
        } else {
            tendenciaActual = new Negativa(tendenciaActual.getFactorDemanda());
        }

        tendenciaActual.actualizarFactorDemanda(ocupacion, capacidad, diferenciaIngresosEgresos);
    }

    //TODO: Las horas hay que manejarlas correctamente.
    public void ingresarVehiculo(String codCochera, Vehiculo v) {
        Cochera c = retornarCochera(codCochera);
        Random random = new Random();
        LocalDateTime horaEntrada = LocalDateTime.of(LocalDate.now(), LocalTime.of(random.nextInt(12), random.nextInt(60), random.nextInt(60)));
        LocalDateTime horaSalida = LocalDateTime.of(LocalDate.now(), LocalTime.of(random.nextInt(12) + 12, random.nextInt(60), random.nextInt(60)));
        Estadia estadia = new Estadia(horaEntrada, horaSalida, c, v);
        if(c.getOcupada()){
            Anomalia unaAnomalia = new Anomalia("HOUDINI");
            estadia.setAnomalias(unaAnomalia);
            
        }
        c.setOcupada(true);
        estadia.setFactorDemandaIngreso(tendenciaActual.getFactorDemanda());
        estadias.add(estadia);
        
         // Aumentar la cuenta corriente del propietario
        Propietario propietario = v.getPropietario();
        if (propietario != null) {
            double valorEstadia = estadia.getValorEstadia();
            propietario.aumentarSaldo(valorEstadia);
        }
    }
    
    private Cochera retornarCochera(String codCochera){
        for(Cochera c: cocheras){
            if(c.retornarCodigo().equals(codCochera)){
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

    public void actualizarValorTipoVehiculo(double nuevoPrecio, int indexTipo) {
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
    
    public List<Estadia> estadiasConAnomalia (){
        List<Estadia> ret = new ArrayList<>();
        
        for(Estadia e : estadias){
            if(e.getAnomalias().size() !=0){
                ret.add(e);
            }
        }
        return ret;
    }
}
