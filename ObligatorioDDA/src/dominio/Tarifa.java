package dominio;


public class Tarifa {
    private float valor;
    private TipoVehiculo tipoVehiculo;

    public Tarifa(float valor, TipoVehiculo tipoVehiculo) {
        this.valor = valor;
        this.tipoVehiculo = tipoVehiculo;
    }

    
    public float getValor() {
        return valor;
    }

    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }
    
}
