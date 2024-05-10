package dominio;

import java.util.ArrayList;
import java.util.List;


public class Vehiculo {
    private String patente;
    private TipoVehiculo tipoVehiculo;
    List<Etiqueta> etiquetas = new ArrayList<>();

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
}
