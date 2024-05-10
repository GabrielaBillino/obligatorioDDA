package dominio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Estadia {
    private Date horaEntrada;
    private Date horaSalida;   
    private Cochera cochera;
    private Vehiculo vehiculo;
    private List<Anomalia> anomalias = new ArrayList<>();
    private List<Infraccion> infracciones = new ArrayList<>();
    private float factorDemandaIngreso;

    public Estadia(Date horaEntrada, Date horaSalida, Cochera cochera, Vehiculo vehiculo) {
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.cochera = cochera;
        this.vehiculo = vehiculo;
        
    }

    public float getFactorDemandaIngreso() {
        return factorDemandaIngreso;
    }

    public Date getHoraEntrada() {
        return horaEntrada;
    }

    public Date getHoraSalida() {
        return horaSalida;
    }

    public Cochera getCochera() {
        return cochera;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public List<Anomalia> getAnomalias() {
        return anomalias;
    }

    public List<Infraccion> getInfracciones() {
        return infracciones;
    }
    
    //********* Confirmar con el profesor que esté correcto *****/////
    public double getValorEstadia(){        
      return (precioBase() *tiempoEstadia() * factorDemandaIngreso)+ totalMultas();
    }
    
    private float tiempoEstadia(){
        return (horaSalida.getTime() - horaEntrada.getTime())/1000;        
    }
    
    //******************************************///////////////////////
    
    private double precioBase(){
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
