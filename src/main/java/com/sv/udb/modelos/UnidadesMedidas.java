/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.modelos;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author bernardo
 */
@Entity
@Table(name = "unidades_medidas", catalog = "vasoleche", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UnidadesMedidas.findAll", query = "SELECT u FROM UnidadesMedidas u")
    , @NamedQuery(name = "UnidadesMedidas.findByCodiUnid", query = "SELECT u FROM UnidadesMedidas u WHERE u.codiUnid = :codiUnid")
    , @NamedQuery(name = "UnidadesMedidas.findByNombUnid", query = "SELECT u FROM UnidadesMedidas u WHERE u.nombUnid = :nombUnid")})
public class UnidadesMedidas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codi_unid")
    private Integer codiUnid;
    @Basic(optional = false)
    @Size(min = 1, max = 50)
    @Column(name = "nomb_unid")
    private String nombUnid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codiUnid", fetch = FetchType.LAZY)
    private List<Leche> lecheList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codiUnid", fetch = FetchType.LAZY)
    private List<Escuelas> escuelasList;

    public UnidadesMedidas() {
    }

    public UnidadesMedidas(Integer codiUnid) {
        this.codiUnid = codiUnid;
    }

    public UnidadesMedidas(Integer codiUnid, String nombUnid) {
        this.codiUnid = codiUnid;
        this.nombUnid = nombUnid;
    }

    public Integer getCodiUnid() {
        return codiUnid;
    }

    public void setCodiUnid(Integer codiUnid) {
        this.codiUnid = codiUnid;
    }

    public String getNombUnid() {
        return nombUnid;
    }

    public void setNombUnid(String nombUnid) {
        this.nombUnid = nombUnid;
    }

    @XmlTransient
    public List<Leche> getLecheList() {
        return lecheList;
    }

    public void setLecheList(List<Leche> lecheList) {
        this.lecheList = lecheList;
    }

    @XmlTransient
    public List<Escuelas> getEscuelasList() {
        return escuelasList;
    }

    public void setEscuelasList(List<Escuelas> escuelasList) {
        this.escuelasList = escuelasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codiUnid != null ? codiUnid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UnidadesMedidas)) {
            return false;
        }
        UnidadesMedidas other = (UnidadesMedidas) object;
        if ((this.codiUnid == null && other.codiUnid != null) || (this.codiUnid != null && !this.codiUnid.equals(other.codiUnid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.udb.modelos.UnidadesMedidas[ codiUnid=" + codiUnid + " ]";
    }
    
}
