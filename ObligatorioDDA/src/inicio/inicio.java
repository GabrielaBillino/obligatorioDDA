package inicio;

import dominio.Cochera;
import dominio.Parking;
import dominio.SensorParking;
import dominio.Vehiculo;
import iuswing.Principal;
import java.util.LinkedHashMap;
import java.util.List;
import simuladortransito.ConfiguracionException;
import simuladortransito.Estacionable;
import simuladortransito.FlujoEgreso;
import simuladortransito.FlujoIngreso;
import simuladortransito.Modo;
import simuladortransito.PerfilEgreso;
import simuladortransito.PerfilIngreso;
import simuladortransito.Periodo;
import simuladortransito.SimuladorTransito;
import simuladortransito.Transitable;

public class inicio {

  
    private static SimuladorTransito simulador;
   
    
    public static void main(String[] args) {
        
       //1. Configurar simulador
       List<Transitable> vehiculos = Precarga.cargarVehiculos();
       List<Estacionable> cocheras = Precarga.cargarCocheras();
   /*    
       simulador = SimuladorTransito.getInstancia();
       simulador.addTransitables(vehiculos);
       simulador.addEstacionables(cocheras);
       
        try {
            //Agrego ingresos y egresos
            simulador.programar(new FlujoIngreso("I1",new Periodo(3,10), 20));
            simulador.programar(new FlujoEgreso("E1",new Periodo(15,10), 20));
//            LinkedHashMap<Transitable, Estacionable> preasignacion = new LinkedHashMap();
//                        listaIngresos.put(vehiculo1, cocheraA);
//                        listaIngresos.put(vehiculo2, cocheraB);
//                        listaIngresos.put(vehiculo3, cocheraC);
//            simulador.programar(new FlujoIngreso("ingreso", new Periodo(0, 1), preasignacion));

            PerfilEgreso perfilConAnomalia = new PerfilEgreso.Builder()                    
                            .generarAnomalia(Modo.SIEMPRE)
                            .build();
            simulador.programar(new FlujoEgreso("anomalias", new Periodo(0, 10), 10, perfilConAnomalia));

            PerfilIngreso perfilConInfracciones = new PerfilIngreso.Builder()
                .invadirEstacionableDiscapacitado(Modo.SIEMPRE)
                .invadirEstacionableElectrico(Modo.ALEATORIO)
                .invadirEstacionableEmpleadoInterno(Modo.NUNCA)
                .build();
            simulador.programar(new FlujoIngreso("infracciones", new Periodo(0, 10), 10, perfilConInfracciones));
           
            //INICIO SIMULACION           
            simulador.iniciar(new SensorParking());
        } catch (ConfiguracionException ex) {
            ex.printStackTrace();
        }
           */  
       
       
       
       List<Parking> parkings = Precarga.cargarParkingsSimulador(cocheras);
      
       Cochera nuevaCochera = (Cochera)cocheras.get(0);
       Cochera nuevaCochera2 = (Cochera)cocheras.get(1);
       Cochera nuevaCochera3 = (Cochera)cocheras.get(2);
       
       Vehiculo nuevoVehiculo = (Vehiculo)vehiculos.get(0);
       Vehiculo nuevoVehiculo2 = (Vehiculo)vehiculos.get(1);
       Vehiculo nuevoVehiculo3 = (Vehiculo)vehiculos.get(2);
       
       //*********INGRESOS VEHICULOS EN PARKING PRIMERO EN LA LISTA******************
       Precarga.ingresarVehiculo(nuevaCochera.getCodigo(), nuevoVehiculo.getPatente(), parkings.get(0));
       Precarga.ingresarVehiculo(nuevaCochera2.getCodigo(), nuevoVehiculo2.getPatente(), parkings.get(0));
       Precarga.ingresarVehiculo(nuevaCochera3.getCodigo(), nuevoVehiculo3.getPatente(), parkings.get(0));

       
       Cochera nuevaCochera4 = (Cochera)cocheras.get(3);
       Cochera nuevaCochera5 = (Cochera)cocheras.get(4);
       Cochera nuevaCochera6 = (Cochera)cocheras.get(5);
       
       Vehiculo nuevoVehiculo4 = (Vehiculo)vehiculos.get(3);
       Vehiculo nuevoVehiculo5 = (Vehiculo)vehiculos.get(4);
       Vehiculo nuevoVehiculo6 = (Vehiculo)vehiculos.get(5);
       //*********INGRESOS VEHICULOS EN PARKING SEGUNDO EN LA LISTA******************
       Precarga.ingresarVehiculo(nuevaCochera4.getCodigo(), nuevoVehiculo4.getPatente(), parkings.get(1));
       Precarga.ingresarVehiculo(nuevaCochera5.getCodigo(), nuevoVehiculo5.getPatente(), parkings.get(1));
       Precarga.ingresarVehiculo(nuevaCochera6.getCodigo(), nuevoVehiculo6.getPatente(), parkings.get(1));
       
       
       Cochera nuevaCochera7 = (Cochera)cocheras.get(6);
       Cochera nuevaCochera8 = (Cochera)cocheras.get(7);
       Cochera nuevaCochera9 = (Cochera)cocheras.get(8);
       
       Vehiculo nuevoVehiculo7 = (Vehiculo)vehiculos.get(6);
       Vehiculo nuevoVehiculo8 = (Vehiculo)vehiculos.get(7);
       Vehiculo nuevoVehiculo9 = (Vehiculo)vehiculos.get(8);
       //*********INGRESOS VEHICULOS EN PARKING SEGUNDO EN LA LISTA******************
       Precarga.ingresarVehiculo(nuevaCochera7.getCodigo(), nuevoVehiculo7.getPatente(), parkings.get(2));
       Precarga.ingresarVehiculo(nuevaCochera8.getCodigo(), nuevoVehiculo8.getPatente(), parkings.get(2));
       Precarga.ingresarVehiculo(nuevaCochera9.getCodigo(), nuevoVehiculo9.getPatente(), parkings.get(2));
       
    //   Precarga.egresarVehiculo(nuevaCochera7.getCodigo(), nuevoVehiculo7.getPatente(), parkings.get(2));
       Precarga.egresarVehiculo(nuevaCochera8.getCodigo(), nuevoVehiculo7.getPatente(), parkings.get(2));
       
       //******Mostrar vista principal******
       Principal principal = new Principal(parkings);
       principal.setVisible(true);
        
    }
    
}
