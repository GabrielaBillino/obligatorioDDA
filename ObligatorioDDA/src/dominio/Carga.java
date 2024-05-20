/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;


public class Carga extends TipoVehiculo{

    public Carga(double precioBase) {
        super(precioBase, "Carga");
    }
   
    @Override
    public double getPrecioBase() {
         return 0.1;
    }
}
