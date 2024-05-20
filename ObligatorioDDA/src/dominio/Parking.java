package dominio;

import java.util.Random;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Parking {

    private String nombre;
    private String direccion;
    private Tarifa tarifa;
    private int capacidad;
    private int ocupacion;
    private List<Cochera> cocheras = new ArrayList<>();
    private List<Estadia> estadias = new ArrayList<>();
    private Queue<Integer> ingresosEgresos;
    private Tendencia tendenciaActual;

    public Parking(String nombre, String direccion, Tarifa tarifa, List<Cochera> cocheras) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.tarifa = tarifa;
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

    public Tarifa getTarifa() {
        return tarifa;
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
    public void cargarEstadia(Cochera c, Vehiculo v) {
        Random random = new Random();
        LocalDateTime horaEntrada = LocalDateTime.of(LocalDate.now(), LocalTime.of(random.nextInt(12), random.nextInt(60), random.nextInt(60)));
        LocalDateTime horaSalida = LocalDateTime.of(LocalDate.now(), LocalTime.of(random.nextInt(12) + 12, random.nextInt(60), random.nextInt(60)));
        Estadia estadia = new Estadia(horaEntrada, horaSalida, c, v);
        estadia.setFactorDemandaIngreso(tendenciaActual.getFactorDemanda());
        estadias.add(estadia);
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
}
