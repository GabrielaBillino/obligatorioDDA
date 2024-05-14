/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
   
    public static List<Parking> cargarParkings (){
        List<Parking> parkings = new ArrayList<>();
        Parking parking1 = new Parking("the Best Parking", "Cuarem 1215", new Tarifa (100, new Motocicleta(200, "Honda")));
        fachada.cargarParking(parking1);
        parkings.add(parking1);
        return  parkings;
    }
        
        
    //*******HAY QUE MODIFICARLO PARA QUE PASE POR LA FACHADA Y HAGA LAS VALIDACIONES ********
    public static List<Transitable> cargarVehiculos(){
        List<Transitable> vehiculos = new ArrayList<>();

        // Tipos de vehículos disponibles
        TipoVehiculo[] tipos = {new Motocicleta(200,"MOTO"), new Carga(300,"CARGA"), new Pasajeros(300,"BUS"), new Standard(100,"COMUN")};

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
    
    public static List<Estacionable> cargarCocheras (){
        List<Estacionable> cocheras = new ArrayList<>();
        // Etiquetas disponibles
        Etiqueta[] etiquetas = {new Discapacitado(), new Electrico(), new Empleado()};
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            // Genera el estado aleatorio (50% de probabilidad de estar libre u ocupada)
            String estado = random.nextBoolean() ? "Libre" : "Ocupada";

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
}
