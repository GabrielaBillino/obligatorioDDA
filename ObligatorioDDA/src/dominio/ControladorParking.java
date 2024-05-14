/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.ArrayList;
import java.util.List;


public class ControladorParking {

    private static List<Parking> parkings = new ArrayList<>();
    
    public static void cargarParking(Parking parking) {
        parkings.add(parking);
    }
    
}
