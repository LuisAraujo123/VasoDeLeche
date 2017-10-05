/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controladores;

import com.sv.udb.modelos.UnidadesMedidas;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author bernardo
 */
@Local
public interface UnidadesMedidasFacadeLocal {

    void create(UnidadesMedidas unidadesMedidas);

    void edit(UnidadesMedidas unidadesMedidas);

    void remove(UnidadesMedidas unidadesMedidas);

    UnidadesMedidas find(Object id);

    List<UnidadesMedidas> findAll();

    List<UnidadesMedidas> findRange(int[] range);

    int count();
    
}
