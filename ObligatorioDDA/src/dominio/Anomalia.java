package dominio;

import Utilidades.Validable;
import excepciones.AnomaliaException;

public class Anomalia implements Validable {

    private String codigo;

    public Anomalia(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    @Override
    public void Validar() throws AnomaliaException {
        validarCodigo();
    }

    private void validarCodigo() throws AnomaliaException {
        if (codigo != "MISTERY" && codigo != "TRANSPORTADOR1" && codigo != "TRANSPORTADOR2" && codigo != "HOUDINI") {
            throw new AnomaliaException("El código de la Anomalía es incorrecto.");
        }
    }

}
