/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.distribuidora.frontend.security;

import com.distribuidora.backend.entities.Usuario;
import com.distribuidora.frontend.utilities.FacesUtils;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;

/**
 *
 * @author Cristian Suesca
 */
@Named(value = "sessionBean")
@SessionScoped
public class SessionBean implements Serializable {

   private Usuario usuario;
    public SessionBean() {
    }
    @PostConstruct
    public void init(){
    usuario = (Usuario) FacesUtils.getObjectSession("usuario");
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public String cerrarSession(){
    FacesUtils.removeObjectSession("usuario");
    usuario = null;
    return "/index.dis?faces-redirect=true";
    }
    
}
