/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.ArrayList;
import java.util.List;


public class Parking {
    private String nombre;
    private String direccion;
    private Tarifa tarifa;
    private List<Cochera> cocheras = new ArrayList<>();

    public Parking(String nombre, String direccion, Tarifa tarifa) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.tarifa = tarifa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Tarifa getTarifa() {
        return tarifa;
    }

    public void setTarifa(Tarifa tarifa) {
        this.tarifa = tarifa;
    }

    public List<Cochera> getCocheras() {
        return cocheras;
    }

    public void setCocheras(List<Cochera> cocheras) {
        this.cocheras = cocheras;
    }
    
    
}
