/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controladores;

import com.sv.udb.modelos.Leche;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author bernardo
 */
@Local
public interface LecheFacadeLocal {

    void create(Leche leche);

    void edit(Leche leche);

    void remove(Leche leche);

    Leche find(Object id);

    List<Leche> findAll();

    List<Leche> findRange(int[] range);

    int count();
    
}
