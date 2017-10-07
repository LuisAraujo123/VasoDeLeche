/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controladores;

import com.sv.udb.modelos.Usuarios;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author bernardo
 */
@Stateless
public class UsuariosFacade extends AbstractFacade<Usuarios> implements UsuariosFacadeLocal {

    @PersistenceContext(unitName = "POOPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuariosFacade() {
        super(Usuarios.class);
    }
    
    @Override
    public Usuarios findByLogiUsua(Usuarios objeUsua) {
        TypedQuery<Usuarios> query = em.createNamedQuery("Usuarios.findByLogiUsua", Usuarios.class);
        query.setParameter("nombUsua", objeUsua.getNombUsua());
        query.setParameter("contUsua", objeUsua.getContUsua());
        if (!query.getResultList().isEmpty())
        {
            return query.getResultList().get(0);
        }
        else
        {
            return null;
        }
    }
    
}
