/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inicio;

import dominio.Sistema;
import dominio.Usuario;


public class Precarga {
    public static void cargarDatos() {
        Sistema fachada = Sistema.getInstancia();
        
        fachada.registrarUsuario(new Usuario("usuario1", "pwu1", "Usuario uno"));
        fachada.registrarUsuario(new Usuario("usuario2", "pwu2", "Usuario dos"));
        fachada.registrarUsuario(new Usuario("usuario3", "pwu3", "Usuario tres"));
    }
    
}
