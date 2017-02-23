/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.distribuidora.frontend.beans;

import com.distribuidora.backend.entities.EstadoUsuario;
import com.distribuidora.backend.facades.EstadoUsuarioFacade;
import com.distribuidora.frontend.logica.IManagedBean;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Cristian Suesca
 * @version 0.1.0
 */
@Named(value = "estadoUsuarioBean")
@RequestScoped
public class EstadoUsuarioBean implements Serializable, IManagedBean<EstadoUsuario>{
    
    private EstadoUsuario estadoUsuario;
    @EJB private EstadoUsuarioFacade ef;
    

   
    public EstadoUsuarioBean() {
    }
@PostConstruct
public void init(){
estadoUsuario = new EstadoUsuario();
}
    @Override
    public EstadoUsuario getObject(Integer i) {
    return ef.find(i);
    }

    public EstadoUsuario getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(EstadoUsuario estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }
    
    public List<EstadoUsuario> listar(){
    return ef.findAll();
    }
    
    public void create(){
    ef.create(estadoUsuario);
    }
    
    
}
