package dominio;

public class Standard extends TipoVehiculo {

    public Standard() {
        super("Standard");
        setPrecioBaseInicial();
    }

    @Override
    protected double calcularPrecioBase() {
        return 0.1;
    }
}
