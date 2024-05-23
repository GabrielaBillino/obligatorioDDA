package dominio;


public abstract class Tendencia {
   protected double factorDemanda;
   protected String nombre;
   
    public Tendencia(double factorDemanda) {
        this.factorDemanda = factorDemanda;
    }

    public String getNombre() {
        return nombre;
    }

    public double getFactorDemanda() {
        return factorDemanda;
    }

    public abstract void actualizarFactorDemanda(int ocupacion, int capacidad, int diferenciaIngresosEgresos);
    
}
