package dominio.TiposDeVehiculos;

import dominio.TiposDeVehiculos.TipoVehiculo;

public class Motocicleta extends TipoVehiculo {

    public Motocicleta() {
        super("Motocicleta");
        setPrecioBaseInicial();
    }

    @Override
    protected double calcularPrecioBase() {
        return 0.05;
    }
}
