/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.distribuidora.frontend.beans;

import com.distribuidora.backend.entities.EstadoUsuario;
import com.distribuidora.frontend.logica.AbstractConverter;
import javax.faces.convert.FacesConverter;



/**
 *
 * @author Cristian Suesca
 * @version 0.1.0
 * @see com.distribuidora.frontend.logica.AbstractConverter
 */

@FacesConverter (forClass = EstadoUsuario.class)
public class EstadoUsuarioConverter extends AbstractConverter{
    
    public EstadoUsuarioConverter(){
    super.namedBean = "estadoUsuarioBean";
    }
    
}
