/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.Date;


public class Estadia {
    private float factorDemanda;
    private Date horaEntrada;
    private Date horaSalida;
    private float precioBase;
    private Cochera cochera;
    private Vehiculo vehiculo;
    private float valorEstadia;

    public Estadia(Date horaEntrada, Date horaSalida, Cochera cochera, Vehiculo vehiculo) {
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.cochera = cochera;
        this.vehiculo = vehiculo;
    }
    
    public float getValorEstadia(){
        //return 0;
      return (precioBase * vehiculo.getTipoVehiculo().getTarifa().getValor() * factorDemanda); //+ multa;
    }
    
    
    
    
    
}
