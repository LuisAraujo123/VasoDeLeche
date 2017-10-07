/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.beans;

import com.sv.udb.modelos.Usuarios;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author bernardo
 */
@Named(value = "plantillaBean")
@ViewScoped
public class PlantillaBean implements Serializable {

    public boolean veriSesi(){
        boolean resp = true;
        try {
            FacesContext ctx = FacesContext.getCurrentInstance();
            Usuarios usuaActu = (Usuarios)ctx.getExternalContext().getSessionMap().get("usuaActu");
            if (usuaActu == null)
            {
                ctx.getExternalContext().redirect("./../permisos.xhtml");
            }
            else
            {
                int codiTipo = usuaActu.getCodiTipo().getCodiTipo();
                if (codiTipo == 1) resp = true;  
                else resp = false;
            }
        } catch (Exception e) {
            resp = false;
        }
        return resp;
    }
    
    public void cerrSesi() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }
}
