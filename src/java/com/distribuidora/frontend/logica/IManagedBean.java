/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.distribuidora.frontend.logica;

/**
 *
 * @author Cristian Suesca
 * @param <T> objeto que reserva la clase para convertirlo
 * @see com.distribuidora.frontend.logica.AbstractConverter
 */
public interface IManagedBean<T> {
 T getObject(Integer i);
    
    
}
