package inicio;

import dominio.Parking;
import iuswing.Principal;
import java.util.List;
import simuladortransito.Estacionable;
import simuladortransito.SimuladorTransito;
import simuladortransito.Transitable;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


public class inicio {

  
    private static SimuladorTransito simulador;
   
    
    public static void main(String[] args) {
        
       //1. Configurar simulador
      List<Transitable> vehiculos = Precarga.cargarVehiculos();
       List<Estacionable> cocheras = Precarga.cargarCocheras();
       
       simulador = SimuladorTransito.getInstancia();
       simulador.addTransitables(vehiculos);
       simulador.addEstacionables(cocheras);
       
       
       List<Parking> parkings = Precarga.cargarParkings();
       
       //******Mostrar vista principal******
       Principal principal = new Principal(parkings);
       principal.setVisible(true);
        
    }
    
}
