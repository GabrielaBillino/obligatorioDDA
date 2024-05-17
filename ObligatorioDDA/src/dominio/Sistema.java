/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.List;


public class Sistema {
    
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
}
