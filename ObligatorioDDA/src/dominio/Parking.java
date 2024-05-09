package dominio;

import java.util.ArrayList;
import java.util.List;


public class Parking {
    private String nombre;
    private String direccion;
    private Tarifa tarifa;
    private List<Cochera> cocheras = new ArrayList<>();
    private List<Estadia> estadias = new ArrayList<>();
    private float factorDemandaActual;
    private String tendenciaActual;

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
    
    public List<Estadia> getEstadias() {
        return estadias;
    }

    public float getFactorDemandaActual() {
        return factorDemandaActual;
    }

    public String getTendenciaActual() {
        return tendenciaActual;
    }
    
    public float calcularOcupacion() {
        return 0;
    }
    
    public void evaluarTendencia() {
        
    }
    
    public void actualizarFactorDemanda() {
        
    }
    
    /*
       
       +-----------------+     *      +-----------------+
       |     Estadia     |<>----------|     Cochera     |
       +-----------------+            +-----------------+
       | - fechaIngreso  |            | - numeroCochera |
       | - fechaSalida   |            | - estadias      |
       | - factorDemandaIngreso |     +-----------------+
       +-----------------+                 |
              ^                             |
              |                             |
              |                             |
              |                             |
              |                             |
       +-----------------+                 |
       |     Parking     |-----------------+
       +-----------------+
       | - cocheras      |
       | - capacidadTotal|
       | - factorDemandaActual |
       | - tendenciaActual: string |
       +-----------------+
       | + calcularOcupacion() : decimal |
       | + evaluarTendencia() : void |
       | + actualizarFactorDemanda() : void |
       +-----------------+

    */

}
