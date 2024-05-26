package dominio;

import Utilidades.UtilidadesVarias;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import simuladortransito.Transitable;


public class Vehiculo implements Transitable{
    private String patente;
    private TipoVehiculo tipoVehiculo;
    private List<Etiqueta> etiquetas = new ArrayList<>();
    private boolean estacionado;   
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

    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }

    public List<Etiqueta> getEtiquetas() {
        return etiquetas;
    }
    
    public double precioBase(){
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
        return UtilidadesVarias.tieneEtiqueta("Empleado",etiquetas);
    }

    public void setEstacionado(boolean b) {
        this.estacionado = b;
    }

    public Propietario getPropietario() {
        return propietario;
    }
    


    @Override
    public boolean equals(Object obj) {
        Vehiculo other = (Vehiculo) obj;
        return this.patente.equals(other.patente);
    }
    

    
}
