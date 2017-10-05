/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controladores;

import com.sv.udb.modelos.UnidadesMedidas;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author bernardo
 */
@Stateless
public class UnidadesMedidasFacade extends AbstractFacade<UnidadesMedidas> implements UnidadesMedidasFacadeLocal {

    @PersistenceContext(unitName = "POOPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UnidadesMedidasFacade() {
        super(UnidadesMedidas.class);
    }
    
}
