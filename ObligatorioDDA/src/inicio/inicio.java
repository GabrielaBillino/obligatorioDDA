package inicio;

import iuswing.Principal;
import simuladortransito.SimuladorTransito;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


public class inicio {

  
    private static SimuladorTransito simulador;
    
    public static void main(String[] args) {
       Precarga.cargarDatos();
       Principal principal = new Principal();
       principal.setVisible(true);
        
    }
    
}
