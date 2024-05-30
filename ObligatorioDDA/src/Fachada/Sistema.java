package Fachada;

import Utilidades.Observable;
import dominio.Cochera;
import dominio.SistemaEstadia;
import dominio.SistemaParking;
import dominio.Parking;
import dominio.Vehiculo;
import excepciones.AnomaliaException;
import excepciones.EstadiaException;
import java.util.List;


public class Sistema extends Observable{
    
    private static Sistema instancia = new Sistema();
    private static SistemaParking controladorParking = new SistemaParking();
    private SistemaEstadia controladorEstadia = new SistemaEstadia();
  

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

    public void ingresarVehiculo(String c, String v, Parking p) throws EstadiaException, AnomaliaException {
        controladorParking.ingresarVehiculo( c,  v,  p);
    }

    public void actualizarValorTipoVehiculo(double nuevoPrecio, int indexTipo, Parking parking) {
        controladorParking.actualizarValorTipoVehiculo(nuevoPrecio, indexTipo, parking);
    }

    public void egresarVehiculo(String c, String v, Parking p) throws EstadiaException, AnomaliaException {
        controladorParking.egresarVehiculo( c,  v,  p);
    }

   
}
