package dominio;

import dominio.TiposDeVehiculos.TipoVehiculo;
import Fachada.Sistema;
import Utilidades.Observable;
import Utilidades.Validable;
import excepciones.TarifaException;


public class Tarifa extends Observable
                              implements Validable {
    private TipoVehiculo tipoVehiculo;

    public Tarifa(TipoVehiculo tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void actualizarPrecio(double nuevoPrecio) {
        tipoVehiculo.setPrecioBase(nuevoPrecio);
        this.avisar(EventoTarifa.NUEVO_PRECIO);
        Sistema.getInstancia().avisar(EventoSistema.NUEVO_PRECIO);
       
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
