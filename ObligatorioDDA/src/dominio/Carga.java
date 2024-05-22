package dominio;

public class Carga extends TipoVehiculo {

    public Carga() {
        super("Carga");
        setPrecioBaseInicial();
    }

    @Override
    protected double calcularPrecioBase() {
        return 0.1;
    }
}