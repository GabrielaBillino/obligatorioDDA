package Fachada;

import Utilidades.Observable;
import dominio.Cochera;
import dominio.SistemaParking;
import dominio.Parking;
import dominio.Vehiculo;
import excepciones.AnomaliaException;
import excepciones.EstadiaException;
import excepciones.TipoVehiculoException;
import java.util.List;


public class Sistema extends Observable{
    
    private static final Sistema instancia = new Sistema();
    private static final SistemaParking controladorParking = new SistemaParking();


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

    public void actualizarValorTipoVehiculo(String nuevoPrecio, int indexTipo, Parking parking) throws TipoVehiculoException {
        controladorParking.actualizarValorTipoVehiculo(nuevoPrecio, indexTipo, parking);
    }

    public void egresarVehiculo(String c, String v, Parking p) throws EstadiaException, AnomaliaException {
        controladorParking.egresarVehiculo( c,  v,  p);
    }

   
}
