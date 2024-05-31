
package controlador;

import dominio.Estadia;
import dominio.Parking;
import iuswing.Cartelera;
import iuswing.ListaDePrecio;
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
    
    public List<Estadia> retornarEstadia(int filaIndex){
        Parking parking = parkings.get(filaIndex);
        return parking.estadiasConAnomalia();
        
    }
    
    public Parking retornarParking(int index){
        return parkings.get(index);
    }
    
    public void abrirCartelera(Parking parking){        
        Cartelera cartelera = new Cartelera(null, false, parking);
        CarteleraController controlerCartelera = new CarteleraController(parking, cartelera);
        cartelera.setVisible(true);
    }

    public void abrirListaPrecio(Parking parking) {       
        ListaDePrecio view = new ListaDePrecio(null, false,parking);
        ListaPrecioController controller = new ListaPrecioController(parking, view);
        view.setVisible(true);
    }
            
            
    
    
}
