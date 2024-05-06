package dominio;

import java.util.ArrayList;
import java.util.List;


public class Propietario {
    private String cedula;
    private String nombreCompleto;
    private List<Vehiculo> vehiculos = new ArrayList<>();
    private CuentaCorriente cuentaCorriente;

    public String getCedula() {
        return cedula;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public CuentaCorriente getCuentaCorriente() {
        return cuentaCorriente;
    }
}
