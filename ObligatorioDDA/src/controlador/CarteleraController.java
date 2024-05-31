
package controlador;

import Fachada.Sistema;
import Utilidades.Observable;
import Utilidades.Observador;
import dominio.EventoSistema;
import dominio.Parking;
import vista.VistaCartelera;



public class CarteleraController
            implements Observador{
   
    private final Parking parking;
    private final VistaCartelera vista;
    private final Sistema fachada = Sistema.getInstancia();
     
    public CarteleraController(Parking parking, VistaCartelera vista) {
        this.vista = vista;
        this.parking = parking;
        fachada.agregar(this);     
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
        vista.mostrarTitulo(titulo);
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
