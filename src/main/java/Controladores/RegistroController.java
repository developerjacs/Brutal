/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Models.Usuario;
import Services.UsuarioService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@Named(value = "registroController")
@RequestScoped
public class RegistroController {

    @Inject
    UsuarioService usuarioService;
    
    private String usuario;
    private String nombre;
    private String apellidos;
    private String contraseña;
    private String correo;
    private String fechaNacimiento;

    public void registrarse() throws ParseException{
        if(usuarioService.obtenerPorUsuario(usuario)==null){
            Usuario us=new Usuario();
            us.setNombre(usuario);
            us.setUsuario(usuario);
            us.setApellidos(apellidos);
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            us.setFechaNacimiento(format.parse(fechaNacimiento));
            us.setContraseña(contraseña);
            us.setCorreo(correo);
            usuarioService.insertarUsuario(us);
        }
    }
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    

}
