
package vista;

import dominio.Parking;
import java.util.List;


public interface VistaTablero {
    public void mostrarTitulo (String titulo);
    public void cargarTabla(List<Parking> parkings);
    
    
}
