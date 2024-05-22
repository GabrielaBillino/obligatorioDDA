package dominio;


public class Tarifa {
    private TipoVehiculo tipoVehiculo;

    public Tarifa(TipoVehiculo tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void actualizarPrecio(double nuevoPrecio) {
        tipoVehiculo.setPrecioBase(nuevoPrecio);
    }
    
    public double getValor() {
        return tipoVehiculo.getPrecioBase();
    }
    
    public String getNombreVehiculo() {
        return tipoVehiculo.getNombre();
    }
}
