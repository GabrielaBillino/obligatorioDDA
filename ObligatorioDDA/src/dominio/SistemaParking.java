package dominio;

import excepciones.AnomaliaException;
import excepciones.EstadiaException;
import excepciones.TipoVehiculoException;
import java.util.ArrayList;
import java.util.List;


public class SistemaParking {

    private static List<Parking> parkings = new ArrayList<>();
    private static List<Cochera> cocheras = new ArrayList<>();
    private static List<Vehiculo> vehiculos = new ArrayList<>();
    
    public void cargarParkings(List<Parking> parkingsParaAgregar) {
        parkings.addAll(parkingsParaAgregar);
    }
    
    public void cargarVehiculos(List<Vehiculo> vehiculosParaAgregar) {
        vehiculos.addAll(vehiculosParaAgregar);
    } 
    
    public void cargarCocheras(List<Cochera> cocherasParaAgregar) {
        cocheras.addAll(cocherasParaAgregar);
    }

    public void ingresarVehiculo(String c, String v, Parking p) throws EstadiaException, AnomaliaException {
       Vehiculo vh = retornarVehiculo(v);
       p.ingresarVehiculo(c,vh);
    }

    private static Vehiculo retornarVehiculo(String patente){
        for(Vehiculo v : vehiculos){
            if(v.retornarPatente().equals(patente)){
                return v;
            }
        }
        return null;
    }
    
    public void actualizarValorTipoVehiculo(String nuevoPrecio, int indexTipo, Parking parking) throws TipoVehiculoException, NumberFormatException {
        parking.actualizarValorTipoVehiculo(nuevoPrecio, indexTipo);
    }

    public void egresarVehiculo(String c, String v, Parking p) throws EstadiaException, AnomaliaException {
       Vehiculo vh = retornarVehiculo(v);
       p.egresarVehiculo(c,vh);
    }
    
}
