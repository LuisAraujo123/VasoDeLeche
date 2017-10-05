/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.beans;

import com.sv.udb.controladores.TiposUsuarioFacadeLocal;
import javax.inject.Named;
import com.sv.udb.modelos.TiposUsuario;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import org.primefaces.context.RequestContext;

/**
 *
 * @author bernardo
 */
@Named(value = "tiposUsuarioBean")
@ViewScoped
public class TiposUsuarioBean implements Serializable {

    @EJB
    private TiposUsuarioFacadeLocal tiposUsuarioFacade;

    private boolean guardando;
    private TiposUsuario objeTipoUsua;
    private List<TiposUsuario> listTipoUsua;    
    /**
     * Creates a new instance of TiposUsuarioBean
     */
    public TiposUsuarioBean() {
    }

    public TiposUsuarioFacadeLocal getTiposUsuarioFacade() {
        return tiposUsuarioFacade;
    }

    public void setTiposUsuarioFacade(TiposUsuarioFacadeLocal tiposUsuarioFacade) {
        this.tiposUsuarioFacade = tiposUsuarioFacade;
    }

    public boolean isGuardando() {
        return guardando;
    }

    public void setGuardando(boolean guardando) {
        this.guardando = guardando;
    }

    public TiposUsuario getObjeTipoUsua() {
        return objeTipoUsua;
    }

    public void setObjeTipoUsua(TiposUsuario objeTipoUsua) {
        this.objeTipoUsua = objeTipoUsua;
    }

    public List<TiposUsuario> getListTipoUsua() {
        return listTipoUsua;
    }
    
    @PostConstruct
    public void init()
    {
        this.objeTipoUsua = new TiposUsuario();
        this.listTipoUsua = this.tiposUsuarioFacade.findAll();
    }
    
    public void nuev()
    {
        RequestContext ctx = RequestContext.getCurrentInstance(); //Capturo el contexto de la página
        this.objeTipoUsua = new TiposUsuario();
        this.guardando = true;
        ctx.execute("$('#modaFormTipo').modal('show')");
    }
    
    public void cons()
    {
        RequestContext ctx = RequestContext.getCurrentInstance(); //Capturo el contexto de la página
        Map<String, String> mapaPrms = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        int codi = Integer.parseInt(mapaPrms.get("codiTipo"));
        this.objeTipoUsua = this.tiposUsuarioFacade.find(codi);
        this.guardando = false;
        ctx.execute("$('#modaFormTipo').modal('show')");
    }
    
    public void guar()
    {
        RequestContext ctx = RequestContext.getCurrentInstance(); //Capturo el contexto de la página
        try
        {
            this.tiposUsuarioFacade.create(this.objeTipoUsua);
            this.listTipoUsua.add(this.objeTipoUsua);
            this.objeTipoUsua = new TiposUsuario();
            ctx.execute("setMessage('MESS_SUCC', 'Atención', 'Datos guardados')");
        }
        catch(Exception ex)
        {
            ctx.execute("setMessage('MESS_ERRO', 'Atención', 'Error al guardar ')");
        }
        finally
        {
            
        }
    }
    
    public void edit()
    {
        RequestContext ctx = RequestContext.getCurrentInstance(); //Capturo el contexto de la página
        try
        {
            this.tiposUsuarioFacade.edit(this.objeTipoUsua);
            this.setItem(this.objeTipoUsua);
            this.objeTipoUsua = new TiposUsuario();
            this.guardando = true;
            ctx.execute("setMessage('MESS_SUCC', 'Atención', 'Datos modificados')");
        }
        catch(Exception ex)
        {
            ctx.execute("setMessage('MESS_ERRO', 'Atención', 'No se modificó')");
        }
        finally
        {
            
        }
    }
    
    public void elim()
    {
        RequestContext ctx = RequestContext.getCurrentInstance(); //Capturo el contexto de la página
        try
        {
            this.tiposUsuarioFacade.remove(this.objeTipoUsua);
            this.listTipoUsua.remove(this.objeTipoUsua);
            this.objeTipoUsua = new TiposUsuario();
            this.guardando = true;
            ctx.execute("setMessage('MESS_SUCC', 'Atención', 'Datos eliminados')");
        }
        catch(Exception ex)
        {
            ctx.execute("setMessage('MESS_ERRO', 'Atención', 'No se eliminó')");
        }
        finally
        {
            
        }
    }
    
    private void setItem(TiposUsuario item)
    {
        int itemIndex = this.listTipoUsua.indexOf(item);
            if (itemIndex != -1) {
            this.listTipoUsua.set(itemIndex, item);
        }
    }
}
