package inicio;

import dominio.TiposDeVehiculos.Carga;
import dominio.Cochera;
import dominio.Etiquetas.Discapacitado;
import dominio.Etiquetas.Electrico;
import dominio.Etiquetas.Empleado;
import dominio.Etiquetas.Etiqueta;
import dominio.TiposDeVehiculos.Motocicleta;
import dominio.Parking;
import dominio.TiposDeVehiculos.Pasajeros;
import dominio.Propietario;
import Fachada.Sistema;
import dominio.TiposDeVehiculos.Standard;
import dominio.Tarifa;
import dominio.TiposDeVehiculos.TipoVehiculo;
import dominio.Vehiculo;
import excepciones.AnomaliaException;
import excepciones.EstadiaException;
import excepciones.ParkingException;
import excepciones.PropietarioException;
import excepciones.TarifaException;
import excepciones.VehiculoException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import simuladortransito.Estacionable;
import simuladortransito.Transitable;

public class Precarga {

    private static Sistema fachada = Sistema.getInstancia();

    public static List<Parking> cargarParkingsSimulador(List<Estacionable> cocherasParkings) throws ParkingException, TarifaException {
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
        Parking parking1 = new Parking("the Best Parking", "Cuareim 1215", generarListaDeTarifas(), retornarCocheras(cocherasParkings));
        parking1.Validar();
        Parking parking2 = new Parking("the Best Parking2", "San José 2281", generarListaDeTarifas(), retornarCocheras(cocherasParkings));
        parking2.Validar();
        Parking parking3 = new Parking("the Best Parking3", "Av. Italia 1621", generarListaDeTarifas(), retornarCocheras(cocherasParkings));
        parking3.Validar();

        parkings.add(parking1);
        parkings.add(parking2);
        parkings.add(parking3);

        fachada.cargarParkings(parkings);
        return parkings;
    }

    private static List<Tarifa> generarListaDeTarifas() throws TarifaException {
        List<Tarifa> tarifas = new ArrayList<Tarifa>();
        Tarifa t1 = new Tarifa(new Motocicleta());
        t1.Validar();
        Tarifa t2 = new Tarifa(new Pasajeros());
        t2.Validar();
        Tarifa t3 = new Tarifa(new Standard());
        t3.Validar();
        Tarifa t4 = new Tarifa(new Carga());
        t4.Validar();
        tarifas.add(t1);
        tarifas.add(t2);
        tarifas.add(t3);
        tarifas.add(t4);
        return tarifas;
    }

    public static List<Transitable> cargarVehiculos() throws VehiculoException, PropietarioException {
        List<Transitable> vehiculos = new ArrayList<>();

        List<Propietario> propietarios = generarPropietariosAleatorios(100);
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
            Propietario unPropietario = propietarios.get(random.nextInt(propietarios.size()));
            // Crea el vehículo con la patente, tipo y etiquetas generadas
            Vehiculo vehiculo = new Vehiculo(patente, tipo, etiquetasVehiculo, unPropietario);
            vehiculo.Validar();
            unPropietario.agregarVehiculo(vehiculo);
            vehiculos.add(vehiculo);
        }

        retornarVehiculosList(vehiculos);
        return vehiculos;

    }

    private static String generarPatente() {
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

    private static List<Propietario> generarPropietariosAleatorios(int cantidad) throws PropietarioException {
        List<Propietario> propietarios = new ArrayList<>();
        Random random = new Random();

        String[] nombres = {"Juan", "María", "Carlos", "Ana", "Luis", "Laura", "Pedro", "Sofía", "Jorge", "Marta"};
        String[] apellidos = {"García", "Rodríguez", "Martínez", "López", "González", "Pérez", "Sánchez", "Ramírez", "Cruz", "Hernández"};

        for (int i = 0; i < cantidad; i++) {
            // Genera una cédula de 8 dígitos
            String cedula = String.valueOf(10000000 + random.nextInt(90000000));
            String nombreCompleto = nombres[random.nextInt(nombres.length)] + " " + apellidos[random.nextInt(apellidos.length)];
            List<Vehiculo> vehiculos = new ArrayList<>();
            Propietario propietario = new Propietario(cedula, nombreCompleto, vehiculos);
            propietario.Validar();
            propietarios.add(propietario);
        }

        return propietarios;
    }

    public static List<Estacionable> cargarCocheras() {
        List<Estacionable> listCocherasEst = new ArrayList<>();
        // Etiquetas disponibles
        Etiqueta[] etiquetas = {new Discapacitado(), new Electrico(), new Empleado()};
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            // Genera el estado aleatorio (50% de probabilidad de estar libre u ocupada)
            boolean estado = false;//random.nextBoolean();

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
            System.out.println("cochera estado "+ cochera.getOcupada());
            listCocherasEst.add(cochera);
        }
        return listCocherasEst;
    }

    public static List<Cochera> retornarCocheras(List<Estacionable> cocheras) {
        List<Cochera> cocherasClonadas = new ArrayList();
        for (Estacionable c : cocheras) {
            Cochera unaCochera = (Cochera) c;
            cocherasClonadas.add(new Cochera(unaCochera.retornarCodigo(), unaCochera.getEtiquetas(), unaCochera.getOcupada()));
        }
        return cocherasClonadas;
    }



    public static List<Vehiculo> retornarVehiculosList(List<Transitable> vehiculos) {
        List<Vehiculo> listaVehiculos = new ArrayList();
        for (Transitable v : vehiculos) {
            listaVehiculos.add((Vehiculo) v);
        }
        fachada.cargarVehiculos(listaVehiculos);
        return listaVehiculos;
        
    }

    public static void ingresarVehiculo(String codCochera, String patente, Parking p) throws EstadiaException, AnomaliaException {
        fachada.ingresarVehiculo(codCochera, patente, p);
    }

    public static void egresarVehiculo(String codCochera, String patente, Parking p) throws EstadiaException, AnomaliaException {
        fachada.egresarVehiculo(codCochera, patente, p);
    }
}
