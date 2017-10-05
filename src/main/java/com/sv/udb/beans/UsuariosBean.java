/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.beans;

import com.sv.udb.controladores.UsuariosFacadeLocal;
import javax.inject.Named;
import com.sv.udb.modelos.Usuarios;
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
@Named(value = "usuariosBean")
@ViewScoped
public class UsuariosBean implements Serializable {

    @EJB
    private UsuariosFacadeLocal usuariosFacade;

    private boolean guardando;
    private Usuarios objeUsua;
    private List<Usuarios> listUsua;

    /**
     * Creates a new instance of UsuariosBean
     */
    public UsuariosBean() {
    }

    public UsuariosFacadeLocal getUsuariosFacade() {
        return usuariosFacade;
    }

    public void setUsuariosFacade(UsuariosFacadeLocal usuariosFacade) {
        this.usuariosFacade = usuariosFacade;
    }

    public boolean isGuardando() {
        return guardando;
    }

    public void setGuardando(boolean guardando) {
        this.guardando = guardando;
    }

    public Usuarios getObjeUsua() {
        return objeUsua;
    }

    public void setObjeUsua(Usuarios objeUsua) {
        this.objeUsua = objeUsua;
    }

    public List<Usuarios> getListUsua() {
        return listUsua;
    }
    
    @PostConstruct
    public void init()
    {
        this.objeUsua = new Usuarios();
        this.listUsua = this.usuariosFacade.findAll();
    }
    
    public void nuev()
    {
        RequestContext ctx = RequestContext.getCurrentInstance(); //Capturo el contexto de la página
        this.objeUsua = new Usuarios();
        this.guardando = true;
        ctx.execute("$('#modaFormUsua').modal('show')");
    }
    
    public void cons()
    {
        RequestContext ctx = RequestContext.getCurrentInstance(); //Capturo el contexto de la página
        Map<String, String> mapaPrms = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        int codi = Integer.parseInt(mapaPrms.get("codiUsua"));
        this.objeUsua = this.usuariosFacade.find(codi);
        this.guardando = false;
        ctx.execute("$('#modaFormUsua').modal('show')");
    }
    
    public void guar()
    {
        RequestContext ctx = RequestContext.getCurrentInstance(); //Capturo el contexto de la página
        try
        {
            this.usuariosFacade.create(this.objeUsua);
            this.listUsua.add(this.objeUsua);
            this.objeUsua = new Usuarios();
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
            this.usuariosFacade.edit(this.objeUsua);
            this.setItem(this.objeUsua);
            this.objeUsua = new Usuarios();
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
            this.usuariosFacade.remove(this.objeUsua);
            this.listUsua.remove(this.objeUsua);
            this.objeUsua = new Usuarios();
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
    
    private void setItem(Usuarios item)
    {
        int itemIndex = this.listUsua.indexOf(item);
            if (itemIndex != -1) {
            this.listUsua.set(itemIndex, item);
        }
    }
}