package dominio;

import java.time.Duration;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.List;

public class Estadia {

    private LocalDateTime horaEntrada;
    private LocalDateTime horaSalida;
    private Cochera cochera;
    private Vehiculo vehiculo;
    private List<Anomalia> anomalias = new ArrayList<>();   
    private double factorDemandaIngreso;

    public Estadia(LocalDateTime horaEntrada, LocalDateTime horaSalida, Cochera cochera, Vehiculo vehiculo) {
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.cochera = cochera;
        this.vehiculo = vehiculo;
        
    }

    public double getFactorDemandaIngreso() {
        return factorDemandaIngreso;
    }

    public void setFactorDemandaIngreso(double factorDemandaIngreso) {
        this.factorDemandaIngreso = factorDemandaIngreso;
    }

    public LocalDateTime getHoraEntrada() {
        return horaEntrada;
    }

    public LocalDateTime getHoraSalida() {
        return horaSalida;
    }

    public Cochera getCochera() {
        return cochera;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public List<Anomalia> getAnomalias() {
        return anomalias;
    }

    public void setAnomalias(Anomalia anomalia) {
        this.anomalias.add(anomalia);
    }

    public double getValorEstadia() {
        double valorEstadia= (precioBase() * tiempoEstadia() * factorDemandaIngreso) + totalMultas();
        return valorEstadia;
    }

    private float tiempoEstadia() {
        Duration duration = Duration.between(horaEntrada, horaSalida);
        return duration.toMinutes();
    }

    //******************************************///////////////////////
    private double precioBase() {
        return vehiculo.precioBase();
    }

    public float totalMultas() {
        float totalMulta = 0;
        List<Etiqueta> etiquetasCocheras = cochera.getEtiquetas();
        List<Etiqueta> etiquetasVehiculos = vehiculo.getEtiquetas();
        for (Etiqueta etiquetaCochera : etiquetasCocheras) {
            boolean etiquetaCorrespondienteEncontrada = false;
            for (Etiqueta etiquetaVehiculo : etiquetasVehiculos) {
                if (etiquetaCochera.equals(etiquetaVehiculo)) {
                    etiquetaCorrespondienteEncontrada = true;
                    break;
                }
            }
            if (!etiquetaCorrespondienteEncontrada) {
                totalMulta += etiquetaCochera.multa(precioBase(), tiempoEstadia());
            }
        }
        return totalMulta;
    }

}
