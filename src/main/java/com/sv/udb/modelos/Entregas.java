/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.modelos;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author bernardo
 */
@Entity
@Table(name = "entregas", catalog = "vasoleche", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entregas.findAll", query = "SELECT e FROM Entregas e")
    , @NamedQuery(name = "Entregas.findByCodiEntr", query = "SELECT e FROM Entregas e WHERE e.codiEntr = :codiEntr")
    , @NamedQuery(name = "Entregas.findByFechEntr", query = "SELECT e FROM Entregas e WHERE e.fechEntr = :fechEntr")
    , @NamedQuery(name = "Entregas.findByEstaEntr", query = "SELECT e FROM Entregas e WHERE e.estaEntr = :estaEntr")})
public class Entregas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codi_entr")
    private Integer codiEntr;
    @Basic(optional = false)
    @Column(name = "fech_entr")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechEntr;
    @Basic(optional = false)
    @Column(name = "esta_entr")
    private short estaEntr;
    @JoinColumn(name = "codi_escu", referencedColumnName = "codi_escu")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Escuelas codiEscu;
    @JoinColumn(name = "codi_lech", referencedColumnName = "codi_lech")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Leche codiLech;

    public Entregas() {
    }

    public Entregas(Integer codiEntr) {
        this.codiEntr = codiEntr;
    }

    public Entregas(Integer codiEntr, Date fechEntr, short estaEntr) {
        this.codiEntr = codiEntr;
        this.fechEntr = fechEntr;
        this.estaEntr = estaEntr;
    }

    public Integer getCodiEntr() {
        return codiEntr;
    }

    public void setCodiEntr(Integer codiEntr) {
        this.codiEntr = codiEntr;
    }

    public Date getFechEntr() {
        return fechEntr;
    }

    public void setFechEntr(Date fechEntr) {
        this.fechEntr = fechEntr;
    }

    public short getEstaEntr() {
        return estaEntr;
    }

    public void setEstaEntr(short estaEntr) {
        this.estaEntr = estaEntr;
    }

    public Escuelas getCodiEscu() {
        return codiEscu;
    }

    public void setCodiEscu(Escuelas codiEscu) {
        this.codiEscu = codiEscu;
    }

    public Leche getCodiLech() {
        return codiLech;
    }

    public void setCodiLech(Leche codiLech) {
        this.codiLech = codiLech;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codiEntr != null ? codiEntr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entregas)) {
            return false;
        }
        Entregas other = (Entregas) object;
        if ((this.codiEntr == null && other.codiEntr != null) || (this.codiEntr != null && !this.codiEntr.equals(other.codiEntr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.udb.modelos.Entregas[ codiEntr=" + codiEntr + " ]";
    }
    
}
