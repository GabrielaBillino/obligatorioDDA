
package controlador;

import dominio.Parking;
import java.util.ArrayList;
import java.util.List;
import vista.VistaTablero;


public class TableroController {
    private List<Parking> parkings = new ArrayList<>();
    private VistaTablero vista;

    public TableroController(List<Parking> parkings, VistaTablero vista) {
        this.vista = vista;
        this.parkings = parkings;
        mostrarTitulo();
        cargarTabla();
    }
    
    
    public void mostrarTitulo(){
        vista.mostrarTitulo("Tablero de control");
    }
    
    public void cargarTabla(){
        vista.cargarTabla(parkings);
    }
    
}
