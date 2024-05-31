package controlador;

import Utilidades.Observable;
import Utilidades.Observador;
import dominio.EventoTarifa;
import dominio.Parking;
import excepciones.TipoVehiculoException;
import iuswing.ListaDePrecio;
import java.awt.event.MouseAdapter;

public class ListaPrecioController
        implements Observador {

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

    public void actualizarValorTipoVehiculo(String nuevoPrecio, int indexTipo){
        try {
            parking.actualizarValorTipoVehiculo(nuevoPrecio, indexTipo);
            view.setMensaje("Valor modificado con éxito.");
        } catch (TipoVehiculoException | NumberFormatException e) {
            view.setError(e.getMessage());
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
