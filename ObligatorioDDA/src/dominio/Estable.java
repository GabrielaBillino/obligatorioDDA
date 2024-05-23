package dominio;


public class Estable extends Tendencia{

    public Estable(double factorDemanda) {
        super(factorDemanda);
    }

     public String getNombre() {
        return "Estable";
    }
   
    @Override
    public void actualizarFactorDemanda(int ocupacion, int capacidad, int diferenciaIngresosEgresos) {
        if (diferenciaIngresosEgresos <= 0.1 * capacidad) {
            factorDemanda = Math.max(0.25, factorDemanda - 0.01);
        }
    }
    
  
}
