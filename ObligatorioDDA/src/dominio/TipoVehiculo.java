package dominio;


public abstract class TipoVehiculo {
    private double precioBase;
    private String nombre;

    public TipoVehiculo(double precioBase, String nombre) {
        this.precioBase = precioBase;
        this.nombre = nombre;
    }

    public TipoVehiculo() {
    }
    
        
    public String getNombre(){
        return nombre;
    }
    
    
    public abstract double getPrecioBase();
    
}
