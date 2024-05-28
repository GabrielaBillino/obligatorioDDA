package dominio.TiposDeVehiculos;

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

    public void setPrecioBase(double nuevoPrecio) {
        precioBase = nuevoPrecio;
    }

    // Método para inicializar el precio base en la subclase
    protected void setPrecioBaseInicial() {
        this.precioBase = calcularPrecioBase();
    }
}
