package dominio;

import Utilidades.Validable;
import excepciones.PropietarioException;
import java.util.ArrayList;
import java.util.List;

public class Propietario implements Validable {

    private String cedula;
    private String nombreCompleto;
    private List<Vehiculo> vehiculos = new ArrayList<>();
    private CuentaCorriente cuentaCorriente;

    public Propietario(String cedula, String nombreCompleto, List<Vehiculo> vehiculos) {
        this.cedula = cedula;
        this.nombreCompleto = nombreCompleto;
        this.vehiculos = vehiculos;
        this.cuentaCorriente = new CuentaCorriente();
    }

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

    public void aumentarSaldo(double monto) {
        this.cuentaCorriente.aumentarSaldo(monto);
    }

    public void agregarVehiculo(Vehiculo vehiculo) {
        this.vehiculos.add(vehiculo);
    }

    void disminuirSaldo(double valorEstadia) {
        this.cuentaCorriente.disminuirSaldo(valorEstadia);
    }

    @Override
    public void Validar() throws PropietarioException {
        validarCedula();
        validarNombre();
        validarVehiculos();
    }

    private void validarCedula() throws PropietarioException {
        if (cedula.isBlank()) {
            throw new PropietarioException("La cédula no puede estar vacía.");
        }
    }

    private void validarNombre() throws PropietarioException {
        if (nombreCompleto.isBlank()) {
            throw new PropietarioException("El nombre no puede estar vacío.");
        }
    }

    private void validarVehiculos() throws PropietarioException {
        if (vehiculos == null) {
            throw new PropietarioException("La lista de vehículos del propietario no puede ser nula.");
        }
    }

}
