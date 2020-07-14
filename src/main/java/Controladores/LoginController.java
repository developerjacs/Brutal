/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Models.Usuario;
import Services.UsuarioService;
import java.io.IOException;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.omnifaces.util.Faces;

/**
 *
 * @author jange
 */
@Named(value = "loginController")
@SessionScoped
public class LoginController implements Serializable {

    @Inject
    UsuarioService usuarioService;
    private String usuario;
    private String contraseña;

    public String login() throws IOException {
        String url = "login.xhtml";
        if (checkLogin()) {
            url = "index.xhtml?faces-redirect=true";
        }

        return url;
    }

    public boolean checkLogin() {
//        boolean ok = false;
//        Usuario us =usuarioService.obtenerPorUsuario(usuario);
//        if(us!=null){
//            if(us.getContraseña().equals(contraseña))
//            ok=true;
//        }
//        return ok;
        return true;
    }

    public void checkPermisos() throws IOException {
        if (!checkLogin()) {
            Faces.redirect("noPermisos.xhtml", null);
        }
    }

    public String registro() {
        return "registro.xhtml?faces-redirect=true";
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

}
