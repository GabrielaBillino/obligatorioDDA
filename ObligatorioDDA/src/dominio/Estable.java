/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;


public class Estable extends Tendencia{

    public Estable(double factorDemanda) {
        super(factorDemanda);
    }

   
    @Override
    public void actualizarFactorDemanda(int ocupacion, int capacidad, int diferenciaIngresosEgresos) {
        if (diferenciaIngresosEgresos <= 0.1 * capacidad) {
            factorDemanda = Math.max(0.25, factorDemanda - 0.01);
        }
    }
    
  
}
