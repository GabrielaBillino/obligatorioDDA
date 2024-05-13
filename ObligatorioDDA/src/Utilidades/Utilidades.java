/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilidades;

import dominio.Etiqueta;
import java.util.List;


public class Utilidades {
    
    public static boolean tieneEtiqueta (String nombreEtiqueta, List<Etiqueta> etiquetas){
        
        for(Etiqueta et : etiquetas){
            if(et.getNombre().equals(nombreEtiqueta)){
                return true;
            }
        }
        return false;
    }
}
