/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasesDeEjemplo;

import simuladortransito.Estacionable;

/**
 *
 * @author PC
 */
public class Cochera implements Estacionable{

    private String codigo;
    private String tipo;
    private boolean ocupada;

    public Cochera(String codigo, String tipo) {
        this.codigo = codigo;
        this.tipo = tipo;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }
    
    @Override
    public String getCodigo() {
        return codigo;
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
        return codigo + " Tipo: " + tipo + " Ocupada: " + (ocupada?"SI":"NO");
    }

    
}
