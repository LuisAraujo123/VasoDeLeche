/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.beans;

import com.sv.udb.controladores.UnidadesMedidasFacadeLocal;
import com.sv.udb.modelos.UnidadesMedidas;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.context.RequestContext;


/**
 *
 * @author bernardo
 */
@Named(value = "unidadesMedidasBean")
@ViewScoped
public class UnidadesMedidasBean implements Serializable {

    @EJB
    private UnidadesMedidasFacadeLocal unidadesMedidasFacade;

    private boolean guardando;
    private UnidadesMedidas objeUnidMedi;
    private List<UnidadesMedidas> listUnidMedi;
    
    /**
     * Creates a new instance of UnidadesMedidasBean
     */
    public UnidadesMedidasBean() {
    }

    public UnidadesMedidasFacadeLocal getUnidadesMedidasFacade() {
        return unidadesMedidasFacade;
    }

    public void setUnidadesMedidasFacade(UnidadesMedidasFacadeLocal unidadesMedidasFacade) {
        this.unidadesMedidasFacade = unidadesMedidasFacade;
    }

    public boolean isGuardando() {
        return guardando;
    }

    public void setGuardando(boolean guardando) {
        this.guardando = guardando;
    }

    public UnidadesMedidas getObjeUnidMedi() {
        return objeUnidMedi;
    }

    public void setObjeUnidMedi(UnidadesMedidas objeUnidMedi) {
        this.objeUnidMedi = objeUnidMedi;
    }

    public List<UnidadesMedidas> getListUnidMedi() {
        return listUnidMedi;
    }

    @PostConstruct
    void init() {
        this.objeUnidMedi = new UnidadesMedidas();
        this.listUnidMedi = this.unidadesMedidasFacade.findAll();
    }
    
    public void nuev()
    {
        RequestContext ctx = RequestContext.getCurrentInstance(); //Capturo el contexto de la página
        this.objeUnidMedi = new UnidadesMedidas();
        this.guardando = true;
        ctx.execute("$('#modaFormUnid').modal('show')");
    }
    
    public void cons()
    {
        RequestContext ctx = RequestContext.getCurrentInstance(); //Capturo el contexto de la página
        Map<String, String> mapaPrms = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        int codi = Integer.parseInt(mapaPrms.get("codiUnid"));
        this.objeUnidMedi = this.unidadesMedidasFacade.find(codi);
        this.guardando = false;
        ctx.execute("$('#modaFormUnid').modal('show')");
    }
    
    public void guar()
    {
        RequestContext ctx = RequestContext.getCurrentInstance(); //Capturo el contexto de la página
        try
        {
            this.unidadesMedidasFacade.create(this.objeUnidMedi);
            this.listUnidMedi.add(this.objeUnidMedi);
            this.objeUnidMedi = new UnidadesMedidas();
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
            this.unidadesMedidasFacade.edit(this.objeUnidMedi);
            this.setItem(this.objeUnidMedi);
            this.objeUnidMedi = new UnidadesMedidas();
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
            this.unidadesMedidasFacade.remove(this.objeUnidMedi);
            this.listUnidMedi.remove(this.objeUnidMedi);
            this.objeUnidMedi = new UnidadesMedidas();
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
    
    private void setItem(UnidadesMedidas item)
    {
        int itemIndex = this.listUnidMedi.indexOf(item);
            if (itemIndex != -1) {
            this.listUnidMedi.set(itemIndex, item);
        }
    }
}