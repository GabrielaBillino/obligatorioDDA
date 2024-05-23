package inicio;

import dominio.Cochera;
import dominio.Parking;
import dominio.SensorParking;
import dominio.Vehiculo;
import iuswing.Principal;
import java.util.List;
import simuladortransito.ConfiguracionException;
import simuladortransito.Estacionable;
import simuladortransito.FlujoEgreso;
import simuladortransito.FlujoIngreso;
import simuladortransito.Periodo;
import simuladortransito.SimuladorTransito;
import simuladortransito.Transitable;

public class inicio {

  
    private static SimuladorTransito simulador;
   
    
    public static void main(String[] args) {
        
       //1. Configurar simulador
       List<Transitable> vehiculos = Precarga.cargarVehiculos();
       List<Estacionable> cocheras = Precarga.cargarCocheras();
       
       /*simulador = SimuladorTransito.getInstancia();
       simulador.addTransitables(vehiculos);
       simulador.addEstacionables(cocheras);
       
        try {
            //Agrego ingresos y egresos
            simulador.programar(new FlujoIngreso("I1",new Periodo(3,10), 20));
            simulador.programar(new FlujoEgreso("E1",new Periodo(15,10), 20));
            //INICIO SIMULACION
           
            simulador.iniciar(new SensorParking());
        } catch (ConfiguracionException ex) {
            ex.printStackTrace();
        }*/
             
       
       
       
       List<Parking> parkings = Precarga.cargarParkingsSimulador();
       
       Precarga.cargarEstadia((Cochera)cocheras.get(0), (Vehiculo)vehiculos.get(0), parkings.get(0));
       Precarga.cargarEstadia((Cochera)cocheras.get(1), (Vehiculo)vehiculos.get(1), parkings.get(1));
       Precarga.cargarEstadia((Cochera)cocheras.get(2), (Vehiculo)vehiculos.get(3), parkings.get(2));

       
       //******Mostrar vista principal******
       Principal principal = new Principal(parkings);
       principal.setVisible(true);
        
    }
    
}
