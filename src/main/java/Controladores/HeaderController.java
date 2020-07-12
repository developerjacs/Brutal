/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author jange
 */
@Named(value = "headerController")
@RequestScoped
public class HeaderController {

    @Inject
    LoginController loginController;

    public String logout(){
        loginController.setContraseña("");
        loginController.setUsuario("");
        return "login.xhtml?faces-redirect=true";
    }
}
