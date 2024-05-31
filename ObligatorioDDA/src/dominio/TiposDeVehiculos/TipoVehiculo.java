package dominio.TiposDeVehiculos;

import excepciones.TipoVehiculoException;

public abstract class TipoVehiculo {
    private double precioBase;
    private String nombre;

    public TipoVehiculo(String nombre) {
        this.nombre = nombre;
    }

    public TipoVehiculo() {
    }

    public String getNombre() {
        return nombre;
    }

    protected abstract double calcularPrecioBase();

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double nuevoPrecio) throws TipoVehiculoException {
        if (nuevoPrecio <= 0) {
            throw new TipoVehiculoException("El precio debe ser mayor a 0.");
        }
        precioBase = nuevoPrecio;
    }

    // Método para inicializar el precio base en la subclase
    protected void setPrecioBaseInicial() {
        this.precioBase = calcularPrecioBase();
    }
}
