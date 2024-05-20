/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;


public class Empleado extends Etiqueta {

    public Empleado() {
        super("Empleado");
    }

    @Override
    public String getNombre() {
        return "Empleado";
    }

    @Override
    public double multa(double montoEstadia, float tiempoEstadiaUT) {
        return tiempoEstadiaUT / 10;
    }
    
}
