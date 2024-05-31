package dominio.Etiquetas;


public class Empleado extends Etiqueta {

    public Empleado() {
        super("Empleado");
    }

    @Override
    public String getNombre() {
        return "Empleado";
    }

    @Override
    public double multa(double montoEstadia, float tiempoEstadiaUT) {
        return tiempoEstadiaUT / 10;
    }
    
}
