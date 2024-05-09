package dominio;


public abstract class TipoVehiculo {
    private float precioBase;
    private String nombre;
    
    public String getNombre(){
        return nombre;
    }
    
    public float getPrecioBase(){
        return precioBase;
    }
    
}
