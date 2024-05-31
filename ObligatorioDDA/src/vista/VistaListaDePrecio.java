package vista;

import dominio.Tarifa;
import java.util.List;


public interface VistaListaDePrecio {
   public void cargarTabla(List<Tarifa> tarifas);
   public void mostrarTitulo(String titulo);
   public void mostrarMensajeExitoso(String mensaje);
   public void mostrarMensajeError(String mensaje);
}
