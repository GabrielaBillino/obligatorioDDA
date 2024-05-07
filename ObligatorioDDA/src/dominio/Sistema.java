/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;


public class Sistema {
    
    private static Sistema instancia = new Sistema();
    private ControladorParking controladorParking = new ControladorParking();
    private ControladorEstadia controladorEstadia = new ControladorEstadia();
    

    public static Sistema getInstancia() {
        return instancia;
    }
}
