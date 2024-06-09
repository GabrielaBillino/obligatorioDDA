package dominio;

import dominio.Etiquetas.Etiqueta;
import dominio.TiposDeVehiculos.TipoVehiculo;
import Utilidades.UtilidadesVarias;
import Utilidades.Validable;
import excepciones.VehiculoException;
import java.util.ArrayList;
import java.util.List;
import simuladortransito.Transitable;

public class Vehiculo implements Transitable, Validable {

    private String patente;
    private TipoVehiculo tipoVehiculo;
    private List<Etiqueta> etiquetas = new ArrayList<>();
    private boolean estacionado = false;
    private Propietario propietario;

    public Vehiculo(String patente, TipoVehiculo tipoVehiculo, List<Etiqueta> etiquetas, Propietario prop) {
        this.patente = patente;
        this.tipoVehiculo = tipoVehiculo;
        this.etiquetas = etiquetas;
        this.propietario = prop;
    }

    @Override
    public String getPatente() {
        return patente;
    }

    public String retornarPatente() {
        return patente;
    }
    
    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }

    public List<Etiqueta> getEtiquetas() {
        return etiquetas;
    }

    public double precioBase() {
        return tipoVehiculo.getPrecioBase();
    }

    @Override
    public boolean esDiscapacitado() {
        return UtilidadesVarias.tieneEtiqueta("Discapacitado", etiquetas);
    }

    @Override
    public boolean esElectrico() {
        return UtilidadesVarias.tieneEtiqueta("Electrico", etiquetas);
    }

    @Override
    public boolean esEmpleado() {
        return UtilidadesVarias.tieneEtiqueta("Empleado", etiquetas);
    }

    public void setEstacionado(boolean b) {
        estacionado = b;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    @Override
    public boolean equals(Object obj) {
        Vehiculo other = (Vehiculo) obj;
        return this.patente.equals(other.patente);
    }

    @Override
    public void Validar() throws VehiculoException {
        validarPatente();
        validarTipo();
        validarEtiquetas();
        validarPropietario();
    }

    private void validarPatente() throws VehiculoException {
        if (patente.isBlank()) {
            throw new VehiculoException("La patente no puede estar vacía.");
        }
    }

    private void validarTipo() throws VehiculoException {
        if (tipoVehiculo == null) {
            throw new VehiculoException("El tipo del vehículo no puede ser nulo.");
        }
    }

    private void validarEtiquetas() throws VehiculoException {
        if (etiquetas == null) {
            throw new VehiculoException("La lista de etiquetas no puede ser nula.");
        }
    }

    private void validarPropietario() throws VehiculoException {
        if (propietario == null) {
            throw new VehiculoException("El propietario del vehículo no puede ser nulo.");
        }
    }

    public String getNombrePropietario() {
        return propietario.getNombreCompleto();
    }

}
