/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;


public class Discapacitado extends Etiqueta{
    

    public Discapacitado() {
        super("Discapacitado");
        
    }

    @Override
    public String getNombre() {
        return "Discapacitado";
    }

    @Override
    public double multa(double montoEstadia, float tiempoEstadiaUT) {
        return 250;
    }
    
  
    
}
