package dominio;

import Utilidades.UtilidadesVarias;
import java.util.ArrayList;
import java.util.List;
import simuladortransito.Estacionable;


public class Cochera  implements Estacionable{
    private String codigo;
    //private String estado;
    private boolean ocupada;
    private List<Etiqueta> etiquetas = new ArrayList<>();
    private static int  lastCodigo = 1;
    
    public Cochera(boolean estado) {
        this.codigo = "A"+ String.valueOf(lastCodigo);
        this.ocupada = estado;
        lastCodigo++;        
    }    

    Cochera() {
        
    }
    
    public void setCodigo (String cod){
        this.codigo = cod;
    }
      
    public boolean getOcupada() {
        return ocupada;
    }

    public List<Etiqueta> getEtiquetas() {
        return etiquetas;
    }

    public String retornarCodigo(){
        return this.codigo;
    }
    
    @Override
    public String getCodigo() {
       return codigo;
    }

    @Override
    public boolean esDiscapacitado() {    
        return UtilidadesVarias.tieneEtiqueta("Discapacitado", etiquetas);
    }

    @Override
    public boolean esElectrico() {
        return UtilidadesVarias.tieneEtiqueta("Electrico", etiquetas);
    }

    @Override
    public boolean esEmpleado() {
        return UtilidadesVarias.tieneEtiqueta("Empleado",etiquetas);
    }

    public void setEtiquetas(List<Etiqueta> etiquetasCochera) {
        this.etiquetas = etiquetasCochera;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }



    @Override
    public boolean equals(Object obj) {
        Cochera other = (Cochera) obj;
        return this.codigo.equals(other.codigo);
    }
    
    
    
   }
