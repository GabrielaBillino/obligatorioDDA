package inicio;

import dominio.Carga;
import dominio.Cochera;
import dominio.Discapacitado;
import dominio.Electrico;
import dominio.Empleado;
import dominio.Etiqueta;
import dominio.Motocicleta;
import dominio.Parking;
import dominio.Pasajeros;
import dominio.Sistema;
import dominio.Standard;
import dominio.Tarifa;
import dominio.TipoVehiculo;
import dominio.Vehiculo;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import simuladortransito.Estacionable;
import simuladortransito.Transitable;

public class Precarga {

    private static Sistema fachada = Sistema.getInstancia();

    public static List<Parking> cargarParkingsSimulador() {
        List<Tarifa> tarifas1 = new ArrayList<>();
        Tarifa t1 = new Tarifa(new Motocicleta());
        Tarifa t2 = new Tarifa(new Pasajeros());
        Tarifa t3 = new Tarifa(new Standard());
        Tarifa t4 = new Tarifa(new Carga());
        tarifas1.add(t1);
        tarifas1.add(t2);
        tarifas1.add(t3);
        tarifas1.add(t4);
        
        List<Tarifa> tarifas2 = new ArrayList<>();
        Tarifa t5 = new Tarifa(new Motocicleta());
        Tarifa t6 = new Tarifa(new Pasajeros());
        Tarifa t7 = new Tarifa(new Standard());
        Tarifa t8 = new Tarifa(new Carga());
        tarifas2.add(t5);
        tarifas2.add(t6);
        tarifas2.add(t7);
        tarifas2.add(t8);
        
        List<Parking> parkings = new ArrayList<>();
        Parking parking1 = new Parking("the Best Parking", "Cuareim 1215", generarListaDeTarifas(), retornarCocheras(cargarCocheras()));
        Parking parking2 = new Parking("the Best Parking2", "San José 2281", generarListaDeTarifas(), retornarCocheras(cargarCocheras()));
        Parking parking3 = new Parking("the Best Parking3", "Av. Italia 1621", generarListaDeTarifas(), retornarCocheras(cargarCocheras()));

        parkings.add(parking1);
        parkings.add(parking2);
        parkings.add(parking3);

        fachada.cargarParkings(parkings);
        return parkings;
    }

    private static List<Tarifa> generarListaDeTarifas() {
        List<Tarifa> tarifas = new ArrayList<Tarifa>();
        Tarifa t1 = new Tarifa(new Motocicleta());
        Tarifa t2 = new Tarifa(new Pasajeros());
        Tarifa t3 = new Tarifa(new Standard());
        Tarifa t4 = new Tarifa(new Carga());
        tarifas.add(t1);
        tarifas.add(t2);
        tarifas.add(t3);
        tarifas.add(t4);
        return tarifas;
    }
  
    public static List<Transitable> cargarVehiculos() {
        List<Transitable> vehiculos = new ArrayList<>();

        // Tipos de vehículos disponibles
        TipoVehiculo[] tipos = {new Motocicleta(), new Carga(), new Pasajeros(), new Standard()};

        // Etiquetas disponibles
        Etiqueta[] etiquetas = {new Discapacitado(), new Electrico(), new Empleado()};

        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            // Selecciona aleatoriamente un tipo de vehículo
            TipoVehiculo tipo = tipos[random.nextInt(tipos.length)];

            // Crea una lista de etiquetas aleatorias
            List<Etiqueta> etiquetasVehiculo = new ArrayList<>();
            for (Etiqueta etiqueta : etiquetas) {
                // Agrega la etiqueta con una probabilidad del 50%
                if (random.nextBoolean()) {
                    etiquetasVehiculo.add(etiqueta);
                }
            }

            // Genera una patente aleatoria
            String patente = generarPatente();

            // Crea el vehículo con la patente, tipo y etiquetas generadas
            Vehiculo vehiculo = new Vehiculo(patente, tipo, etiquetasVehiculo);
            vehiculos.add(vehiculo);
        }
        return vehiculos;

    }

    public static String generarPatente() {
        StringBuilder patente = new StringBuilder();
        Random random = new Random();

        // Genera las tres letras iniciales
        for (int i = 0; i < 3; i++) {
            char c = (char) ('A' + random.nextInt(26));
            patente.append(c);
        }

        // Genera los cuatro números siguientes
        for (int i = 0; i < 4; i++) {
            patente.append(random.nextInt(10)); // Agrega un dígito aleatorio entre 0 y 9
        }

        return patente.toString();
    }

    public static List<Estacionable> cargarCocheras() {
        List<Estacionable> cocheras = new ArrayList<>();
        // Etiquetas disponibles
        Etiqueta[] etiquetas = {new Discapacitado(), new Electrico(), new Empleado()};
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            // Genera el estado aleatorio (50% de probabilidad de estar libre u ocupada)
            boolean estado = random.nextBoolean();

            // Crea una lista de etiquetas aleatorias para la cochera
            List<Etiqueta> etiquetasCochera = new ArrayList<>();
            for (Etiqueta etiqueta : etiquetas) {
                // Agrega la etiqueta con una probabilidad del 50%
                if (random.nextBoolean()) {
                    etiquetasCochera.add(etiqueta);
                }
            }

            // Crea la cochera con el estado y etiquetas generadas
            Cochera cochera = new Cochera(estado);
            cochera.setEtiquetas(etiquetasCochera);
            cocheras.add(cochera);
        }
        return cocheras;
    }

    private static List<Cochera> retornarCocheras(List<Estacionable> cocheras) {
        List<Cochera> listaCocheras = new ArrayList();
        for (Estacionable c : cocheras) {
            listaCocheras.add((Cochera) c);
        }
        fachada.cargarCocheras(listaCocheras);
        return listaCocheras;
    }
    
    public static void cargarEstadia(Cochera c, Vehiculo v, Parking p){
        fachada.cargarEstadia(c,v,p);
    }
}
