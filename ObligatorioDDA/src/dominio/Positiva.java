package dominio;


public class Positiva extends Tendencia{

    public Positiva(double factorDemanda) {
        super(factorDemanda);
    }
    
    @Override
     public String getNombre() {
        return "Positiva";
    }

    @Override
    public void actualizarFactorDemanda(int ocupacion, int capacidad, int diferenciaIngresosEgresos) {
        if (diferenciaIngresosEgresos > 0.1 * capacidad) {
            if (ocupacion < 33) {
                factorDemanda = Math.min(10, factorDemanda + 0.05);
            } else if (ocupacion < 66) {
                factorDemanda = Math.min(10, factorDemanda + 0.1);
            } else {
                factorDemanda = Math.min(10, factorDemanda + 0.15);
            }
        }
    }
    

    
}
