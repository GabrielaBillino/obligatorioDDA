package dominio;

import java.util.ArrayList;
import java.util.List;


public class Cochera {
    private int codigo;
    private static int  lastCodigo = 1;
    private String estado;
    private List<Etiqueta> etiquetas = new ArrayList<>();

    public Cochera(String estado) {
        this.codigo = lastCodigo;
        this.estado = estado;
        lastCodigo++;        
    }    
    
    public int getCodigo() {
        return codigo;
    }

    public String getEstado() {
        return estado;
    }

    public List<Etiqueta> getEtiquetas() {
        return etiquetas;
    }
}
