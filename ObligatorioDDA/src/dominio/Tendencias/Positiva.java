package dominio.Tendencias;

public class Positiva extends Tendencia {

    public Positiva(double factorDemanda) {
        super(factorDemanda);
        this.nombre = "Positiva";
    }

    @Override
    public void actualizarFactorDemanda(int ocupacion, int capacidad, int duracion) {
        double ocupacionPorcentaje = ocupacion / (double) capacidad;

        if (ocupacionPorcentaje < 0.33) {
            modificarFactorDemanda(duracion, 0.05);
        } else if (ocupacionPorcentaje <= 0.66) {
            modificarFactorDemanda(duracion, 0.1);
        } else {
            modificarFactorDemanda(duracion, 0.15);
        }
    }

    private void modificarFactorDemanda(int duracion, double modificacion) {
        int i = duracion;
        while (i > 0 && this.factorDemanda < 10) {
            this.factorDemanda = Math.min(10, this.factorDemanda + modificacion);
            i--;
        }
    }

}
