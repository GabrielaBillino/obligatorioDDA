package inicio;

import dominio.Cochera;
import dominio.Estadia;
import dominio.Parking;
import dominio.SensorParking;
import dominio.Vehiculo;
import excepciones.AnomaliaException;
import excepciones.EstadiaException;
import excepciones.ParkingException;
import excepciones.PropietarioException;
import excepciones.TarifaException;
import excepciones.VehiculoException;
import iuswing.Principal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;
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
    private static final Random random = new Random();

    public static void main(String[] args) throws VehiculoException, EstadiaException, PropietarioException, ParkingException, AnomaliaException, TarifaException {

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
        List<Vehiculo> vehiculosPre = Precarga.retornarVehiculosList(vehiculos);
        List<Cochera> cocherasPre = Precarga.retornarCocheras(cocheras);

        //*********INGRESOS VEHICULOS EN PARKING PRIMERO EN LA LISTA******************       
        precargarIngresoVehiculos(40, cocherasPre, vehiculosPre, parkings.get(0));

        //*********INGRESOS VEHICULOS EN PARKING SEGUNDO EN LA LISTA******************     
        precargarIngresoVehiculos(10, cocherasPre, vehiculosPre, parkings.get(1));
        precargarIngresoVehiculos(15, cocherasPre, vehiculosPre, parkings.get(1));
        precargarEgresoVehiculos(15, cocherasPre, vehiculosPre, parkings.get(1));

        //*********INGRESOS VEHICULOS EN PARKING TERCER EN LA LISTA******************       
        precargarIngresoVehiculos(20, cocherasPre, vehiculosPre, parkings.get(2));
        precargarEgresoVehiculos(10, cocherasPre, vehiculosPre, parkings.get(2));

        //******Mostrar vista principal******
        Principal principal = new Principal(parkings);
        principal.setVisible(true);

    }

    public static void precargarIngresoVehiculos(int cantidad, List<Cochera> cocheras, List<Vehiculo> vehiculos, Parking parking) throws EstadiaException, AnomaliaException {
        for (int i = 0; i < cantidad; i++) {
            Cochera cochera = cocheras.get(random.nextInt(cocheras.size()));
            Vehiculo vehiculo = vehiculos.get(random.nextInt(vehiculos.size()));
            Precarga.ingresarVehiculo(cochera.retornarCodigo(), vehiculo.getPatente(), parking);
        }
    }

    public static void precargarEgresoVehiculos(int cantidad, List<Cochera> cocheras, List<Vehiculo> vehiculos, Parking parking) throws EstadiaException, AnomaliaException {
        for (int i = 0; i < cantidad; i++) {
            Cochera cochera = cocheras.get(random.nextInt(cocheras.size()));
            Vehiculo vehiculo = vehiculos.get(random.nextInt(vehiculos.size()));
            Precarga.egresarVehiculo(cochera.retornarCodigo(), vehiculo.getPatente(), parking);
        }
    }
}
