package dominio.Etiquetas;

import dominio.Etiquetas.Etiqueta;


public class Discapacitado extends Etiqueta{
    

    public Discapacitado() {
        super("Discapacitado");
        
    }

    @Override
    public String getNombre() {
        return "Discapacitado";
    }

    @Override
    public double multa(double montoEstadia, float tiempoEstadiaUT) {
        return 250;
    }
    
  
    
}
