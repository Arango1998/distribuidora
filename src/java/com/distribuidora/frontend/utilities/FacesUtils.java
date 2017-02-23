/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.distribuidora.frontend.utilities;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Cristian Suesca
 */
public class FacesUtils {

    public static void showFacesMessage(String titulo, String contenido, int tipo) {
        FacesContext context = FacesContext.getCurrentInstance();
        switch (tipo) {
            case 1:
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, titulo, contenido));
                break;
            case 2:
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, titulo, contenido));
                break;
            case 3:
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, titulo, contenido));
                break;
            case 4:
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, titulo, contenido));
                break;
        }
    }
}
