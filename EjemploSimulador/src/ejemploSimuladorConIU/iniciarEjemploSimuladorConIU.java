/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemploSimuladorConIU;

import clasesDeEjemplo.DatosPrueba;
import clasesDeEjemplo.SensorDePrueba;
import java.util.ArrayList;
import simuladorIU.SimuladorIU;
import simuladortransito.Estacionable;
import simuladortransito.Transitable;


/**
 *
 * @author PC
 */
public class iniciarEjemploSimuladorConIU {
    
    
    public static void main(String[] args) {
        SensorDePrueba sensor= new SensorDePrueba();
        ArrayList<Estacionable> cocheras = DatosPrueba.getCocheras(50);
        ArrayList<Transitable> vehiculos = DatosPrueba.getVehiculos(50);
        new SimuladorIU(null, false,sensor,cocheras,vehiculos).setVisible(true);
        
        
    }

   
    
}
