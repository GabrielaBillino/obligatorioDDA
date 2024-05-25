package dominio;

import Utilidades.Observable;
import java.util.List;


public class Sistema extends Observable{
    
    private static Sistema instancia = new Sistema();
    private static ControladorParking controladorParking = new ControladorParking();
    private ControladorEstadia controladorEstadia = new ControladorEstadia();
    private ControladorUsuario controladorUsuario = new ControladorUsuario();

    public static Sistema getInstancia() {
        return instancia;
    }
    
    public Usuario login(String username, String password) {
        return controladorUsuario.login(username, password);
    }
    
     public void registrarUsuario(Usuario usuario) {
        controladorUsuario.registrarUsuario(usuario);
    }

    public static void cargarParkings(List<Parking> parkings) {
        controladorParking.cargarParkings(parkings);
    }
    
    public static void cargarCocheras(List<Cochera> cocheras) {
        controladorParking.cargarCocheras(cocheras);
    }

    public void cargarEstadia(Cochera c, Vehiculo v, Parking p) {
        controladorParking.cargarEstadia( c,  v,  p);
    }

    public void actualizarValorTipoVehiculo(double nuevoPrecio, int indexTipo, Parking parking) {
        controladorParking.actualizarValorTipoVehiculo(nuevoPrecio, indexTipo, parking);
    }
}
