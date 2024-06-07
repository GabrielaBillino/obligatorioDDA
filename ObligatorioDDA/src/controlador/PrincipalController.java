package controlador;

import vista.VistaPrincipal;

public class PrincipalController {
    private VistaPrincipal vista;
    
    public PrincipalController(VistaPrincipal vista) {
        this.vista = vista;
        mostrarTitulo();
    }
    
    public void mostrarTitulo(){
        vista.mostrarTitulo("Gestión Parkings");
    }
}
