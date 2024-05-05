/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Estadia {
    private float factorDemanda;
    private Date horaEntrada;
    private Date horaSalida;   
    private Cochera cochera;
    private Vehiculo vehiculo;
    private List<Anomalia> anomalias = new ArrayList<>();
    private List<Infraccion> infracciones = new ArrayList<>();

    public Estadia(Date horaEntrada, Date horaSalida, Cochera cochera, Vehiculo vehiculo) {
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.cochera = cochera;
        this.vehiculo = vehiculo;
        
    }

    public float getFactorDemanda() {
        return factorDemanda;
    }

    public void setFactorDemanda(float factorDemanda) {
        this.factorDemanda = factorDemanda;
    }

    public Date getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(Date horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public Date getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Date horaSalida) {
        this.horaSalida = horaSalida;
    }

    public Cochera getCochera() {
        return cochera;
    }

    public void setCochera(Cochera cochera) {
        this.cochera = cochera;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public List<Anomalia> getAnomalias() {
        return anomalias;
    }

    public void setAnomalias(List<Anomalia> anomalias) {
        this.anomalias = anomalias;
    }

    public List<Infraccion> getInfracciones() {
        return infracciones;
    }

    public void setInfracciones(List<Infraccion> infracciones) {
        this.infracciones = infracciones;
    }
    
       
    
    //********* Confirmar con el profesor que esté correcto *****/////
    public float getValorEstadia(){        
      return (precioBase() *tiempoEstadia() * factorDemanda)+ totalMultas();
    }
    
    private float tiempoEstadia(){
        return (horaSalida.getTime() - horaEntrada.getTime())/1000;        
    }
    
    //******************************************///////////////////////
    private float precioBase(){
        return vehiculo.precioBase();
    }
    
    private float totalMultas(){
        float ret = 0;
        
        for(Infraccion i : infracciones){
            ret += i.getMonto();
        }
        return ret;
    }
    
    
}
