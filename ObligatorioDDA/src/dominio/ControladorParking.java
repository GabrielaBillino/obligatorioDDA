package dominio;

import java.util.ArrayList;
import java.util.List;


public class ControladorParking {

    private static List<Parking> parkings = new ArrayList<>();
    private static List<Cochera> cocheras = new ArrayList<>();
    
    public static void cargarParkings(List<Parking> parkingsParaAgregar) {
        if (parkingsParaAgregar != null) {
            parkings.addAll(parkingsParaAgregar);
        }
    }
    
    public static void cargarCocheras(List<Cochera> cocherasParaAgregar) {
        cocheras.addAll(cocherasParaAgregar);
    }

    public void cargarEstadia(Cochera c, Vehiculo v, Parking p) {
       p.cargarEstadia(c,v);
    }

    public void actualizarValorTipoVehiculo(double nuevoPrecio, int indexTipo, Parking parking) {
        parking.actualizarValorTipoVehiculo(nuevoPrecio, indexTipo);
    }
    
}
