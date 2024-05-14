package dominio;

import Utilidades.Utilidades;
import java.util.ArrayList;
import java.util.List;
import simuladortransito.Estacionable;


public class Cochera  implements Estacionable{
    private int codigo;    
    private String estado;
    private List<Etiqueta> etiquetas = new ArrayList<>();    
    private static int  lastCodigo = 1;
    
    public Cochera(String estado) {
        this.codigo = lastCodigo;
        this.estado = estado;
        lastCodigo++;        
    }    
      

    public String getEstado() {
        return estado;
    }

    public List<Etiqueta> getEtiquetas() {
        return etiquetas;
    }

    @Override
    public String getCodigo() {
       return String.valueOf(codigo);
    }

    @Override
    public boolean esDiscapacitado() {    
        return Utilidades.tieneEtiqueta("Discapacitado", etiquetas);
    }

    @Override
    public boolean esElectrico() {
        return Utilidades.tieneEtiqueta("Electrico", etiquetas);
    }

    @Override
    public boolean esEmpleado() {
        return Utilidades.tieneEtiqueta("Empleado",etiquetas);
    }

    public void setEtiquetas(List<Etiqueta> etiquetasCochera) {
        this.etiquetas = etiquetasCochera;
    }
    
   
}
