/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controladores;

import com.sv.udb.modelos.Leche;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author bernardo
 */
@Stateless
public class LecheFacade extends AbstractFacade<Leche> implements LecheFacadeLocal {

    @PersistenceContext(unitName = "POOPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LecheFacade() {
        super(Leche.class);
    }
    
}
