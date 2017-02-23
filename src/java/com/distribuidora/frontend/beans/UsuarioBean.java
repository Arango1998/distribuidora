/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.distribuidora.frontend.beans;

import com.distribuidora.backend.entities.Usuario;
import com.distribuidora.backend.facades.UsuarioFacade;
import com.distribuidora.frontend.logica.IManagedBean;
import com.distribuidora.frontend.utilities.FacesUtils;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author Cristian Suesca
 */
@Named(value = "usuarioBean")
@RequestScoped
public class UsuarioBean implements Serializable, IManagedBean<Usuario> {

    private Usuario usuario;
    @EJB
    private UsuarioFacade uf;
    @Inject
    private EstadoUsuarioBean estadoUsuarioBean;

    public UsuarioBean() {
    }

    @PostConstruct
    public void init() {
        usuario = new Usuario();
    }

    @Override
    public Usuario getObject(Integer i) {
        return uf.find(i);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public EstadoUsuarioBean getEstadoUsuarioBean() {
        return estadoUsuarioBean;
    }

    public List<Usuario> listUsers() {
        return uf.findAll();
    }

    public void create() {
        try {
            usuario.setIdEstado(estadoUsuarioBean.getObject(1));
            uf.create(usuario);
            FacesUtils.showFacesMessage("Exito", "Usuario: " + getUsuario().getNombres() + " " + getUsuario().getApellidos() + "Registrado", 2);
        } catch (Exception e) {
            FacesUtils.showFacesMessage("Exito", "Usuario: " + getUsuario().getUsuario() + "Ya existe", 1);
        }

    }

    public String iniciarSesion() {
        return "";
    }

}
