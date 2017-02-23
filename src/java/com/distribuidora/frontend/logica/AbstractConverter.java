/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.distribuidora.frontend.logica;

import com.distribuidora.backend.entities.IEntity;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author Cristian Suesca
 */
public abstract class AbstractConverter implements Converter {

    protected String namedBean;

    @Override
    public Object getAsObject(FacesContext context, UIComponent uic, String value) {
        try {
            Integer i = Integer.valueOf(value);
            IManagedBean managedBean = (IManagedBean) context.getELContext().getELResolver()
                    .getValue(context.getELContext(), null, namedBean);
            return managedBean.getObject(i);
        } catch (NumberFormatException e) {

            System.out.println("error en convertir objeto");

        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        try {
            if (value instanceof IEntity) {
                IEntity entidad = (IEntity) value;
                return entidad.getPK();

            } else {
                System.out.println("no se encontro la entidad del objeto");
            }
        } catch (Exception e) {
            System.out.println("no se pudo convertir a String");
        }
        return null;
    }

}
