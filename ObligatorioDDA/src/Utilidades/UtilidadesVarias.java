package Utilidades;

import dominio.Etiqueta;
import java.util.List;


public class UtilidadesVarias {

    public static boolean tieneEtiqueta (String nombreEtiqueta, List<Etiqueta> etiquetas){
        for(Etiqueta et : etiquetas){
            if(et.getNombre().equals(nombreEtiqueta)){
                return true;
            }
        }
        return false;
    }
}
