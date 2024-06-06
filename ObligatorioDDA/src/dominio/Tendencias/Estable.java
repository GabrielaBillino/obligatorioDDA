package dominio.Tendencias;




public class Estable extends Tendencia{

    public Estable(double factorDemanda) {
        super(factorDemanda);
        this.nombre = "Estable";
    }

   
   
    @Override
    public void actualizarFactorDemanda(int ocupacion, int capacidad, int diferenciaIngresosEgresos) {
//        if (diferenciaIngresosEgresos <= 0.1 * capacidad) {
//            factorDemanda = Math.max(0.25, factorDemanda - 0.01);
//        }
         if (this.factorDemanda > 0.25) {
            this.factorDemanda = Math.max(0.25, this.factorDemanda - 0.01);
        }
    }
    
  
}
