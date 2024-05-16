/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasesDeEjemplo;

import simuladortransito.Transitable;

/**
 *
 * @author PC
 */
public class Vehiculo implements Transitable{

    private String matricula;
    private String tipo;
    private boolean estacionado;

    public Vehiculo(String matricula, String tipo) {
        this.matricula = matricula;
        this.tipo = tipo;
    }

    public void setEstacionado(boolean estacionado) {
        this.estacionado = estacionado;
    }
    
    @Override
    public String getPatente() {
        return matricula;
    }

    @Override
    public boolean esDiscapacitado() {
        return tipo.equals("DISCAPACITADO");
    }

    @Override
    public boolean esElectrico() {
        return  tipo.equals("ELECTRICO");
    }

    @Override
    public boolean esEmpleado() {
        return tipo.equals("EMPLEADO");
    }

    @Override
    public String toString() {
        return matricula + " Tipo: " + tipo + " Estacionado: " + (estacionado?"SI":"NO");
    }
    
    
}
