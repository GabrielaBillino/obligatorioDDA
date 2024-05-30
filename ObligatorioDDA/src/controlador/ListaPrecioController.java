
package controlador;

import Utilidades.Observable;
import Utilidades.Observador;
import dominio.EventoTarifa;
import dominio.Parking;
import iuswing.ListaDePrecio;
import java.awt.event.MouseAdapter;


public class ListaPrecioController
                implements Observador{
    
    private final Parking parking;
    private final ListaDePrecio view;

    public ListaPrecioController(ListaDePrecio view, Parking parking) {
        this.view = view;
        this.parking = parking;
        parking.agregar(this);
        initView();
        initController();
    }
private void initView() {
        view.setTitle("Lista de precios - " + parking.getNombre());
        view.cargarTabla(parking.getTarifa());
    }

    private void initController() {
        
    }

    public  void actualizarValorTipoVehiculo(double nuevoPrecio,int indexTipo){
        parking.actualizarValorTipoVehiculo(nuevoPrecio, indexTipo);
    }



    private boolean esNumerico(String text) {
        try {
            Double.parseDouble(text);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public void actualizar(Observable origen, Object evento) {
        if (evento.equals(EventoTarifa.NUEVO_PRECIO)) {
            view.cargarTabla(parking.getTarifa());
            view.setTitle("Lista de precios - " + parking.getNombre());
        }
    }
}
