package dominio.Etiquetas;


public class Electrico extends Etiqueta{

    public Electrico() {
        super("Electrico");
    }

    @Override
    public String getNombre() {
        return "Electrico";
    }

    @Override
    public double multa(double montoEstadia, float tiempoEstadiaUT) {
        return montoEstadia * 0.5;
    }
    
}
