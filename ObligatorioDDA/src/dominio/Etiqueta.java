package dominio;

import java.util.Objects;


public  abstract class  Etiqueta {
    private String nombre;

    public Etiqueta(String nombre) {
        this.nombre = nombre;
    }

    
    public abstract String getNombre();
       

   

    @Override
    public boolean equals(Object obj) {
        Etiqueta other = (Etiqueta) obj;
        return this.nombre.equals(other.nombre);
    }
    
    
   
}
