/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;


public class Standard extends TipoVehiculo {

    public Standard(double precioBase) {
        super(precioBase, "Standard");
    }
    
     @Override
    public double getPrecioBase() {
         return 0.1;
    }
}
