/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;


public class Motocicleta extends TipoVehiculo {

    public Motocicleta(double precioBase) {
        super(precioBase, "Motocicleta");
    }

    @Override
    public double getPrecioBase() {
        return 0.05;
    }
    
}
