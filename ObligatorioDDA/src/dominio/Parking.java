package dominio;

import java.util.ArrayList;
import java.util.List;


public class Parking {
    private String nombre;
    private String direccion;
    private Tarifa tarifa;
    private List<Cochera> cocheras = new ArrayList<>();

    public Parking(String nombre, String direccion, Tarifa tarifa) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.tarifa = tarifa;
    }

     public Parking(String nombre) {
        this.nombre = nombre;
       
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public Tarifa getTarifa() {
        return tarifa;
    }

    public List<Cochera> getCocheras() {
        return cocheras;
    }
}
