/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Models.Usuario;
import Services.UsuarioService;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author jange
 */
@Named("indexController")
@ViewScoped
public class IndexController implements Serializable{

  
    @Inject
    UsuarioService usuarioService;
    
    private String saludo;
    private List<Usuario> usuarios;
    
    @PostConstruct
    public void init() {
        saludo="hola";
        usuarios = usuarioService.obtenerTodos();
    }

    public String getSaludo() {
        return saludo;
    }

    public void setSaludo(String saludo) {
        this.saludo = saludo;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    
    
    
}
