/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author jange
 */
@Named("indexController")
@ViewScoped
public class IndexController implements Serializable{

    /**
     * Creates a new instance of IndexController
     */
    
    private String saludo;
    
    @PostConstruct
    public void init() {
        saludo="hola";
    }

    public String getSaludo() {
        return saludo;
    }

    public void setSaludo(String saludo) {
        this.saludo = saludo;
    }
    
    
    
}
