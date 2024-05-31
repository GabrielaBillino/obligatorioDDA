package controlador;

import Utilidades.Observable;
import Utilidades.Observador;
import dominio.EventoTarifa;
import dominio.Parking;
import excepciones.TipoVehiculoException;
import vista.VistaListaDePrecio;

public class ListaPrecioController
        implements Observador {

    private final Parking parking;
    private VistaListaDePrecio vista;

    public ListaPrecioController(Parking parking, VistaListaDePrecio vista) {
        this.vista = vista;
        this.parking = parking;
        parking.agregar(this);     
        mostrarTitulo();
        cargarTabla();
    }
 

  
    public void mostrarTitulo(){
        String titulo = "Lista de precios - " + parking.getNombre();
        vista.mostrarTitulo(titulo);
    }

    public void cargarTabla(){
        vista.cargarTabla(parking.getTarifa());
    }
    
    public void actualizarValorTipoVehiculo(String nuevoPrecio, int indexTipo){
        try {
            parking.actualizarValorTipoVehiculo(nuevoPrecio, indexTipo);
            vista.mostrarMensajeExitoso("Valor modificado con éxito.");
        } catch (TipoVehiculoException | NumberFormatException e) {
            vista.mostrarMensajeError(e.getMessage());
        }
    }

    @Override
    public void actualizar(Observable origen, Object evento) {
        if (evento.equals(EventoTarifa.NUEVO_PRECIO)) {
            cargarTabla(); 
            mostrarTitulo();
        }
    }

    public void quitar() {
        parking.quitar(this);
    }
}
