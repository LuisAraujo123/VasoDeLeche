/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controladores;

import com.sv.udb.modelos.TiposUsuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author bernardo
 */
@Local
public interface TiposUsuarioFacadeLocal {

    void create(TiposUsuario tiposUsuario);

    void edit(TiposUsuario tiposUsuario);

    void remove(TiposUsuario tiposUsuario);

    TiposUsuario find(Object id);

    List<TiposUsuario> findAll();

    List<TiposUsuario> findRange(int[] range);

    int count();
    
}
