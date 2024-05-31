
package vista;

import dominio.Tarifa;
import java.util.List;
import java.util.Map;


public interface VistaCartelera {
    public void mostrarTitulo(String titulo);
    public void cargarTablaTipoVehiculo(List<Tarifa> tarifas);
    public void cargarTablaCocheras(Map<String, Integer> listado);
    
}
