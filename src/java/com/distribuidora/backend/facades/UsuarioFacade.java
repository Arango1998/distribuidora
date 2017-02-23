/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.distribuidora.backend.facades;

import com.distribuidora.backend.entities.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.persistence.TypedQuery;

/**
 *
 * @author Cristian Suesca
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "FutbolWebUsuarioPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }

    public Usuario autenticar(Usuario u) {
        try {
            TypedQuery<Usuario> usuarioList = getEntityManager().createNamedQuery("Usuario.findByUsuario", Usuario.class)
                    .setParameter("usuario", u.getUsuario());
            if (usuarioList.getResultList().get(0).getClave().equals(u.getClave())) {
                return usuarioList.getResultList().get(0);
            }

        }catch (Exception e) {}
            return null;
        }
        }
    

