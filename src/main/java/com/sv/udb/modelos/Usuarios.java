/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.modelos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author bernardo
 */
@Entity
@Table(name = "usuarios", catalog = "vasoleche", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u")
    , @NamedQuery(name = "Usuarios.findByCodiUsua", query = "SELECT u FROM Usuarios u WHERE u.codiUsua = :codiUsua")
    , @NamedQuery(name = "Usuarios.findByNombUsua", query = "SELECT u FROM Usuarios u WHERE u.nombUsua = :nombUsua")
    , @NamedQuery(name = "Usuarios.findByContUsua", query = "SELECT u FROM Usuarios u WHERE u.contUsua = :contUsua")
    , @NamedQuery(name = "Usuarios.findByMailUsua", query = "SELECT u FROM Usuarios u WHERE u.mailUsua = :mailUsua")
    , @NamedQuery(name = "Usuarios.findByEstaUsua", query = "SELECT u FROM Usuarios u WHERE u.estaUsua = :estaUsua")})
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codi_usua")
    private Integer codiUsua;
    @Basic(optional = false)
    @Size(min = 1, max = 100)
    @Column(name = "nomb_usua")
    private String nombUsua;
    @Basic(optional = false)
    @Size(min = 1, max = 250)
    @Column(name = "cont_usua")
    private String contUsua;
    @Basic(optional = false)
    @Size(min = 1, max = 120)
    @Column(name = "mail_usua")
    private String mailUsua;
    @Basic(optional = false)
    @Column(name = "esta_usua")
    private short estaUsua;
    @JoinColumn(name = "codi_tipo", referencedColumnName = "codi_tipo")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TiposUsuario codiTipo;

    public Usuarios() {
    }

    public Usuarios(Integer codiUsua) {
        this.codiUsua = codiUsua;
    }

    public Usuarios(Integer codiUsua, String nombUsua, String contUsua, String mailUsua, short estaUsua) {
        this.codiUsua = codiUsua;
        this.nombUsua = nombUsua;
        this.contUsua = contUsua;
        this.mailUsua = mailUsua;
        this.estaUsua = estaUsua;
    }

    public Integer getCodiUsua() {
        return codiUsua;
    }

    public void setCodiUsua(Integer codiUsua) {
        this.codiUsua = codiUsua;
    }

    public String getNombUsua() {
        return nombUsua;
    }

    public void setNombUsua(String nombUsua) {
        this.nombUsua = nombUsua;
    }

    public String getContUsua() {
        return contUsua;
    }

    public void setContUsua(String contUsua) {
        this.contUsua = contUsua;
    }

    public String getMailUsua() {
        return mailUsua;
    }

    public void setMailUsua(String mailUsua) {
        this.mailUsua = mailUsua;
    }

    public short getEstaUsua() {
        return estaUsua;
    }

    public void setEstaUsua(short estaUsua) {
        this.estaUsua = estaUsua;
    }

    public TiposUsuario getCodiTipo() {
        return codiTipo;
    }

    public void setCodiTipo(TiposUsuario codiTipo) {
        this.codiTipo = codiTipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codiUsua != null ? codiUsua.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.codiUsua == null && other.codiUsua != null) || (this.codiUsua != null && !this.codiUsua.equals(other.codiUsua))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.udb.modelos.Usuarios[ codiUsua=" + codiUsua + " ]";
    }
    
}
