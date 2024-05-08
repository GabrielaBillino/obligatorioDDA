package dominio;


public abstract class TipoVehiculo {
    private Tarifa tarifa;
    private String nombre;

    public Tarifa getTarifa() {
        return tarifa;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public float precioBase(){
        return tarifa.getValor();
    }
    
}
