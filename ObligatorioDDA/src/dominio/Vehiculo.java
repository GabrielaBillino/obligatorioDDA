package dominio;

import Utilidades.Utilidades;
import java.util.ArrayList;
import java.util.List;
import simuladortransito.Transitable;


public class Vehiculo implements Transitable{
    private String patente;
    private TipoVehiculo tipoVehiculo;
    List<Etiqueta> etiquetas = new ArrayList<>();

    
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
        return Utilidades.tieneEtiqueta("Discapacitado", etiquetas);
    }

    @Override
    public boolean esElectrico() {
        return Utilidades.tieneEtiqueta("Electrico", etiquetas);
    }

    @Override
    public boolean esEmpleado() {
        return Utilidades.tieneEtiqueta("Empleado",etiquetas);
    }
}
