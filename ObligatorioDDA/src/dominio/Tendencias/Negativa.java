package dominio.Tendencias;


public class Negativa extends Estable{
    
    public Negativa(double factorDemanda) {
        super(factorDemanda);
        this.nombre = "Negativa";
    }

       
     @Override
    public void actualizarFactorDemanda(int ocupacion, int capacidad, int diferenciaIngresosEgresos) {
//         if (diferenciaIngresosEgresos < 0) {
//            if (factorDemanda > 1) {
//                factorDemanda = 1;
//            } else {
//                factorDemanda = Math.max(0.25, factorDemanda - 0.05);
//            }
//        }
        if (this.factorDemanda > 1) {
            this.factorDemanda = 1;
        } else if (this.factorDemanda > 0.25) {
            this.factorDemanda = Math.max(0.25, this.factorDemanda - 0.05);
        }
    }
    
  
    
    
}
