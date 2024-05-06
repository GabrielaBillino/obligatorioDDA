package dominio;


public class TipoVehiculo {
    private Tarifa tarifa;

    public Tarifa getTarifa() {
        return tarifa;
    }
    
    public float precioBase(){
        return tarifa.getValor();
    }
    
}
