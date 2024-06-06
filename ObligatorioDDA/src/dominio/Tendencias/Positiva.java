package dominio.Tendencias;


public class Positiva extends Tendencia{

    public Positiva(double factorDemanda) {
        super(factorDemanda);
        this.nombre = "Positiva";
    }
    
  

    @Override
    public void actualizarFactorDemanda(int ocupacion, int capacidad, int diferenciaIngresosEgresos) {
//        if (diferenciaIngresosEgresos > 0.1 * capacidad) {
//            if (ocupacion < 33) {
//                factorDemanda = Math.min(10, factorDemanda + 0.05);
//            } else if (ocupacion < 66) {
//                factorDemanda = Math.min(10, factorDemanda + 0.1);
//            } else {
//                factorDemanda = Math.min(10, factorDemanda + 0.15);
//            }
//        }
        double ocupacionPorcentaje = ocupacion / (double) capacidad;

        if (ocupacionPorcentaje < 0.33) {
            this.factorDemanda = Math.min(10, this.factorDemanda + 0.05);
        } else if (ocupacionPorcentaje < 0.66) {
            this.factorDemanda = Math.min(10, this.factorDemanda + 0.1);
        } else {
            this.factorDemanda = Math.min(10, this.factorDemanda + 0.15);
        }
    }
    

    
}
