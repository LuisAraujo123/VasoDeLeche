/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controladores;

import com.sv.udb.modelos.Entregas;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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
    
    @Override
    public List<Entregas> findByEstaEntr(Entregas objeEntr) {
        TypedQuery<Entregas> query = em.createNamedQuery("Entregas.findByEstaEntr", Entregas.class);
        query.setParameter("estaEntr", objeEntr.getEstaEntr());
        if (!query.getResultList().isEmpty())
        {
            return query.getResultList();
        }
        else
        {
            return null;
        }
    }
}
