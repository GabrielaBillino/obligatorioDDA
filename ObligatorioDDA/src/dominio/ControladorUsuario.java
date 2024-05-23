package dominio;

import java.util.ArrayList;
import java.util.List;


public class ControladorUsuario {
    private List<Usuario> usuarios = new ArrayList<>();
    
    public Usuario login(String username, String password) {
        for (Usuario usuario : usuarios) {
            if (usuario.getUsername().equals(username) &&
                    usuario.getPassword().equals(password)) {
                return usuario;
            }
        }
        return null;
    }
    
    public void registrarUsuario(Usuario usuario) {
        if (validarListaUsuarios(usuario)) {
            usuarios.add(usuario);
        }
    }

    private boolean validarListaUsuarios(Usuario usuario) {
        if (usuarios.contains(usuario)) {
            return false;
        }
        return true;
    }
    
}
