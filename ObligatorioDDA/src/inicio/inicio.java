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
             
       
       
       
       List<Parking> parkings = Precarga.cargarParkingsSimulador();
       
       Precarga.cargarPropietarios();
       
       Precarga.ingresarVehiculo((Cochera)cocheras.get(0).getCodigo(), (Vehiculo)vehiculos.get(0).getPatente(), parkings.get(0));
//       Precarga.cargarEstadia((Cochera)cocheras.get(1), (Vehiculo)vehiculos.get(1), parkings.get(1));
//       Precarga.cargarEstadia((Cochera)cocheras.get(2), (Vehiculo)vehiculos.get(3), parkings.get(2));

       
       //******Mostrar vista principal******
       Principal principal = new Principal(parkings);
       principal.setVisible(true);
        
    }
    
}
