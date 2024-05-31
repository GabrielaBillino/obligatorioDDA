package dominio;

import dominio.TiposDeVehiculos.TipoVehiculo;
import Fachada.Sistema;
import Utilidades.Observable;
import Utilidades.Validable;
import excepciones.TarifaException;
import excepciones.TipoVehiculoException;

public class Tarifa extends Observable
        implements Validable {

    private TipoVehiculo tipoVehiculo;

    public Tarifa(TipoVehiculo tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void actualizarPrecio(String nuevoPrecio) throws TipoVehiculoException, NumberFormatException {
        double precioParseado = esNumerico(nuevoPrecio);
        tipoVehiculo.setPrecioBase(precioParseado);
        this.avisar(EventoTarifa.NUEVO_PRECIO);
        Sistema.getInstancia().avisar(EventoSistema.NUEVO_PRECIO);
    }

    private double esNumerico(String text) throws NumberFormatException {
        try {
            double precioParseado = Double.parseDouble(text);
            return precioParseado;
        } catch (NumberFormatException e) {
            throw new NumberFormatException("El valor '" + text + "' no es un número válido.");
        }
    }

    public double getValor() {
        return tipoVehiculo.getPrecioBase();
    }

    public String getNombreVehiculo() {
        return tipoVehiculo.getNombre();
    }

    @Override
    public void Validar() throws TarifaException {
        validarTipo();
    }

    private void validarTipo() throws TarifaException {
        if (tipoVehiculo == null) {
            throw new TarifaException("El tipo de vehículo no puede ser nulo.");
        }
    }
}
