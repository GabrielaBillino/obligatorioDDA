/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasesDeEjemplo;

import java.util.ArrayList;
import simuladortransito.Estacionable;
import simuladortransito.Transitable;

/**
 *
 * @author PC
 */
public class DatosPrueba {
    
    private static String[] tipos = {"DISCAPACITADO" , "ELECTRICO" , "EMPLEADO", "SIN ETIQUETA"};
    
    public static ArrayList<Estacionable> getCocheras(int cuantos) {
        ArrayList<Estacionable> lista = new ArrayList();
        for(int x=0;x<cuantos;x++){
            lista.add(new Cochera("C"+ x , tipos[x%4]));
        }
        return lista;
    }

    public static ArrayList<Transitable> getVehiculos(int cuantos) {
        ArrayList<Transitable> lista = new ArrayList();
        for(int x=0;x<cuantos;x++){
            lista.add(new Vehiculo("M"+ x , tipos[x%4]));
        }
         return lista;
    }
    
    
}
