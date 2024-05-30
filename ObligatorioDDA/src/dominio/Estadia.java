package dominio;

import Utilidades.Validable;
import dominio.Etiquetas.Etiqueta;
import excepciones.EstadiaException;
import java.time.Duration;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.List;

public class Estadia implements Validable {

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
        if (contieneHoudini() || contieneTransportador()) {
            return 0;
        }
        double valorEstadia = (precioBase() * tiempoEstadia() * factorDemandaIngreso) + totalMultas();
        return valorEstadia;
    }

    private boolean contieneHoudini() {
        for (Anomalia a : anomalias) {
            if (a.getCodigo().equals("HOUDINI")) {
                return true;
            }
        }
        return false;
    }

    private boolean contieneTransportador() {
        for (Anomalia a : anomalias) {
            if (a.getCodigo().equals("TRANSPORTADOR1") || a.getCodigo().equals("TRANSPORTADOR2")) {
                return true;
            }
        }
        return false;
    }

    private float tiempoEstadia() {
        if (contieneHoudini()) {
            horaSalida = null;
            return 0;
        }
        Duration duration = Duration.between(horaEntrada, horaSalida);
        return duration.toMinutes();
    }

    private double precioBase() {
        return vehiculo.precioBase();
    }

    public float totalMultas() {
        float totalMulta = 0;
        if (contieneHoudini() || contieneTransportador()) {
            return totalMulta;
        }
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

    public void setFechaSalida(LocalDateTime horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String retornarPatenteVehiculo() {
        return this.vehiculo.getPatente();
    }

    public String retornarCodCochera() {
        return this.cochera.retornarCodigo();
    }

    @Override
    public void Validar() throws EstadiaException {
        validarHoraEntrada();
        validarCochera();
        validarVehiculo();
    }

    private void validarHoraEntrada() throws EstadiaException {
        if (horaEntrada == null) {
            throw new EstadiaException("La hora de entrada no puede ser nula.");
        }
    }

    private void validarCochera() throws EstadiaException {
        if (cochera == null) {
            throw new EstadiaException("La cochera no puede ser nula.");
        }
    }

    private void validarVehiculo() throws EstadiaException {
        if (vehiculo == null) {
            throw new EstadiaException("El vehículo no puede ser nulo.");
        }
    }

}
