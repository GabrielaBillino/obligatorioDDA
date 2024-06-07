package dominio.Tendencias;


public class Negativa extends Tendencia{
    
    public Negativa(double factorDemanda) {
        super(factorDemanda);
        this.nombre = "Negativa";
    }

     
     @Override
    public void actualizarFactorDemanda(int ocupacion, int capacidad, int duracion) {
        if (this.factorDemanda > 1) {
            this.factorDemanda = 1;
        } else if (this.factorDemanda <= 1) {
            int i = duracion;
            while (i > 0 && this.factorDemanda > 0.25) {
                this.factorDemanda = Math.max(0.25, this.factorDemanda - 0.05);
                i--;
            }
        }
    }
    
  
    
    
}
