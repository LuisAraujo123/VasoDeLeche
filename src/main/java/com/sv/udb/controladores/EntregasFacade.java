/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controladores;

import com.sv.udb.modelos.Entregas;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author bernardo
 */
@Stateless
public class EntregasFacade extends AbstractFacade<Entregas> implements EntregasFacadeLocal {

    @PersistenceContext(unitName = "POOPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EntregasFacade() {
        super(Entregas.class);
    }
    
}
