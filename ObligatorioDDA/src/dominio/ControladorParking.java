package dominio;

import java.util.ArrayList;
import java.util.List;


public class ControladorParking {

    private static List<Parking> parkings = new ArrayList<>();
    private static List<Cochera> cocheras = new ArrayList<>();
    private static List<Vehiculo> vehiculos = new ArrayList<>();
    
    public static void cargarParkings(List<Parking> parkingsParaAgregar) {
        if (parkingsParaAgregar != null) {
            parkings.addAll(parkingsParaAgregar);
        }
    }
    
    public static void cargarVehiculos(List<Vehiculo> vehiculosParaAgregar) {
        vehiculos.addAll(vehiculosParaAgregar);
    } 
    
    public static void cargarCocheras(List<Cochera> cocherasParaAgregar) {
        cocheras.addAll(cocherasParaAgregar);
    }

    public static void ingresarVehiculo(String c, String v, Parking p) {
       Vehiculo vh = retornarVehiculo(v);
       p.ingresarVehiculo(c,vh);
    }

    private static Vehiculo retornarVehiculo(String patente){
        for(Vehiculo v : vehiculos){
            if(v.getPatente().equals(patente)){
                return v;
            }
        }
        return null;
    }
    
    public void actualizarValorTipoVehiculo(double nuevoPrecio, int indexTipo, Parking parking) {
        parking.actualizarValorTipoVehiculo(nuevoPrecio, indexTipo);
    }
    
}
