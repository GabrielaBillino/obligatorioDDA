/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;


public class Negativa extends Estable{
    
    public Negativa(double factorDemanda) {
        super(factorDemanda);
    }
    
     @Override
    public void actualizarFactorDemanda(int ocupacion, int capacidad, int diferenciaIngresosEgresos) {
         if (diferenciaIngresosEgresos < 0) {
            if (factorDemanda > 1) {
                factorDemanda = 1;
            } else {
                factorDemanda = Math.max(0.25, factorDemanda - 0.05);
            }
        }
    }
    
    
}
