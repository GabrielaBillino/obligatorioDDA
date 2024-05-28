package dominio;

import Fachada.Sistema;
import Utilidades.Observable;


public class Tarifa extends Observable{
    private TipoVehiculo tipoVehiculo;

    public Tarifa(TipoVehiculo tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void actualizarPrecio(double nuevoPrecio) {
        tipoVehiculo.setPrecioBase(nuevoPrecio);
        this.avisar(EventoTarifa.NUEVO_PRECIO);
        Sistema.getInstancia().avisar(EventoSistema.NUEVO_PRECIO);
       
    }
    
    public double getValor() {
        return tipoVehiculo.getPrecioBase();
    }
    
    public String getNombreVehiculo() {
        return tipoVehiculo.getNombre();
    }
}
