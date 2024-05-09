package inicio;

import iuswing.Principal;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


public class inicio {

  
    public static void main(String[] args) {
       Precarga.cargarDatos();
       Principal principal = new Principal();
       principal.setVisible(true);
        
    }
    
}
