
package controlador;

import Utilidades.Observable;
import Utilidades.Observador;
import dominio.EventoSistema;
import dominio.Parking;
import dominio.Tarifa;
import java.util.List;
import vista.VistaCartelera;



public class CarteleraController
            implements Observador{
   
    private final Parking parking;
    private VistaCartelera vista;
     
    public CarteleraController(Parking parking, VistaCartelera vista) {
        this.vista = vista;
        this.parking = parking;
        parking.agregar(this);     
        mostrarTitulo();
        cargarTablaTipoVehiculo();
        cargarTablaCocheras();
    }
     
    public void cargarTablaCocheras(){
        vista.cargarTablaCocheras(parking.contarCocherasEtiquetas());
    }
     
    public void cargarTablaTipoVehiculo(){
        vista.cargarTablaTipoVehiculo(parking.getTarifa());
    }
    
    
     private void mostrarTitulo() {
        String titulo = "Cartelera - " + parking.getNombre();

       
    }
    
    
       @Override
    public void actualizar(Observable origen, Object evento) {
        if (evento.equals(EventoSistema.NUEVO_PRECIO)) {
            cargarTablaTipoVehiculo();
            cargarTablaCocheras();
            mostrarTitulo();
        }
    }
}
