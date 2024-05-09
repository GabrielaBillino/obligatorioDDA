/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;


public class Usuario {
     private String username;
    private String password;
    private String nombreCompleto;

     public Usuario(String username, String password, String nombreCompleto) {
        this.username = username;
        this.password = password;
        this.nombreCompleto = nombreCompleto;       
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
    
    
     @Override
    public boolean equals(Object obj) {
        Usuario usuario = (Usuario) obj;
        return this.username.equals(usuario.username);
    }
}