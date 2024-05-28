package Fachada;

import Utilidades.Observable;
import dominio.Cochera;
import dominio.ControladorEstadia;
import dominio.ControladorParking;
import dominio.Parking;
import dominio.Vehiculo;
import java.util.List;
import simuladortransito.Transitable;


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

    public void ingresarVehiculo(String c, String v, Parking p) {
        controladorParking.ingresarVehiculo( c,  v,  p);
    }

    public void actualizarValorTipoVehiculo(double nuevoPrecio, int indexTipo, Parking parking) {
        controladorParking.actualizarValorTipoVehiculo(nuevoPrecio, indexTipo, parking);
    }

    public void egresarVehiculo(String c, String v, Parking p) {
        controladorParking.egresarVehiculo( c,  v,  p);
    }

   
}
