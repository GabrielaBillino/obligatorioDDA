package dominio;

import Utilidades.Observable;
import java.util.List;


public class Sistema extends Observable{
    
    private static Sistema instancia = new Sistema();
    private static ControladorParking controladorParking = new ControladorParking();
    private ControladorEstadia controladorEstadia = new ControladorEstadia();
  

    public static Sistema getInstancia() {
        return instancia;
    }
    
   
    public static void cargarParkings(List<Parking> parkings) {
        controladorParking.cargarParkings(parkings);
    }
    
    public static void cargarCocheras(List<Cochera> cocheras) {
        controladorParking.cargarCocheras(cocheras);
    }
    
    public static void cargarVehiculos(List<Vehiculo> vehiculos) {
        controladorParking.cargarVehiculos(vehiculos);
    }

    public void ingresarVehiculo(int c, String v, Parking p) {
        controladorParking.ingresarVehiculo( c,  v,  p);
    }

    public void actualizarValorTipoVehiculo(double nuevoPrecio, int indexTipo, Parking parking) {
        controladorParking.actualizarValorTipoVehiculo(nuevoPrecio, indexTipo, parking);
    }
}
