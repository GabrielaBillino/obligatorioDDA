package dominio;

import java.util.Objects;


public  abstract class  Etiqueta {
    private String nombre;

    public String getNombre() {
        return nombre;
    }

   

    @Override
    public boolean equals(Object obj) {
        Etiqueta other = (Etiqueta) obj;
        return this.nombre.equals(other.nombre);
    }
    
    
   
}
