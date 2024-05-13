package dominio;


public abstract class TipoVehiculo {
    private double precioBase;
    private String nombre;
    
    public String getNombre(){
        return nombre;
    }
    
    
    public abstract double getPrecioBase();
    
}
