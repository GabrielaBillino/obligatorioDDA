package dominio.TiposDeVehiculos;

import dominio.TiposDeVehiculos.TipoVehiculo;

public class Pasajeros extends TipoVehiculo {

    public Pasajeros() {
        super("Pasajeros");
        setPrecioBaseInicial();
    }

    @Override
    protected double calcularPrecioBase() {
        return 0.1;
    }
}
