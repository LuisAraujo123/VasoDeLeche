/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.modelos;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author bernardo
 */
@Entity
@Table(name = "leche", catalog = "vasoleche", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Leche.findAll", query = "SELECT l FROM Leche l")
    , @NamedQuery(name = "Leche.findByCodiLech", query = "SELECT l FROM Leche l WHERE l.codiLech = :codiLech")
    , @NamedQuery(name = "Leche.findByNombLech", query = "SELECT l FROM Leche l WHERE l.nombLech = :nombLech")
    , @NamedQuery(name = "Leche.findByCantLeche", query = "SELECT l FROM Leche l WHERE l.cantLeche = :cantLeche")
    , @NamedQuery(name = "Leche.findByPrecLech", query = "SELECT l FROM Leche l WHERE l.precLech = :precLech")
    , @NamedQuery(name = "Leche.findByFechLote", query = "SELECT l FROM Leche l WHERE l.fechLote = :fechLote")
    , @NamedQuery(name = "Leche.findByFechVenc", query = "SELECT l FROM Leche l WHERE l.fechVenc = :fechVenc")})
public class Leche implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codi_lech")
    private Integer codiLech;
    @Basic(optional = false)
    @Size(min = 1, max = 150)
    @Column(name = "nomb_lech")
    private String nombLech;
    @Basic(optional = false)
    @Column(name = "cant_leche")
    private int cantLeche;
    @Basic(optional = false)
    @Column(name = "prec_lech")
    private double precLech;
    @Basic(optional = false)
    @Column(name = "fech_lote")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechLote;
    @Basic(optional = false)
    @Column(name = "fech_venc")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechVenc;
    @JoinColumn(name = "codi_escu", referencedColumnName = "codi_escu")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Escuelas codiEscu;
    @JoinColumn(name = "codi_unid", referencedColumnName = "codi_unid")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private UnidadesMedidas codiUnid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codiLech", fetch = FetchType.LAZY)
    private List<Entregas> entregasList;

    public Leche() {
    }

    public Leche(Integer codiLech) {
        this.codiLech = codiLech;
    }

    public Leche(Integer codiLech, String nombLech, int cantLeche, double precLech, Date fechLote, Date fechVenc) {
        this.codiLech = codiLech;
        this.nombLech = nombLech;
        this.cantLeche = cantLeche;
        this.precLech = precLech;
        this.fechLote = fechLote;
        this.fechVenc = fechVenc;
    }

    public Integer getCodiLech() {
        return codiLech;
    }

    public void setCodiLech(Integer codiLech) {
        this.codiLech = codiLech;
    }

    public String getNombLech() {
        return nombLech;
    }

    public void setNombLech(String nombLech) {
        this.nombLech = nombLech;
    }

    public int getCantLeche() {
        return cantLeche;
    }

    public void setCantLeche(int cantLeche) {
        this.cantLeche = cantLeche;
    }

    public double getPrecLech() {
        return precLech;
    }

    public void setPrecLech(double precLech) {
        this.precLech = precLech;
    }

    public Date getFechLote() {
        return fechLote;
    }

    public void setFechLote(Date fechLote) {
        this.fechLote = fechLote;
    }

    public Date getFechVenc() {
        return fechVenc;
    }

    public void setFechVenc(Date fechVenc) {
        this.fechVenc = fechVenc;
    }

    public Escuelas getCodiEscu() {
        return codiEscu;
    }

    public void setCodiEscu(Escuelas codiEscu) {
        this.codiEscu = codiEscu;
    }

    public UnidadesMedidas getCodiUnid() {
        return codiUnid;
    }

    public void setCodiUnid(UnidadesMedidas codiUnid) {
        this.codiUnid = codiUnid;
    }

    @XmlTransient
    public List<Entregas> getEntregasList() {
        return entregasList;
    }

    public void setEntregasList(List<Entregas> entregasList) {
        this.entregasList = entregasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codiLech != null ? codiLech.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Leche)) {
            return false;
        }
        Leche other = (Leche) object;
        if ((this.codiLech == null && other.codiLech != null) || (this.codiLech != null && !this.codiLech.equals(other.codiLech))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.udb.modelos.Leche[ codiLech=" + codiLech + " ]";
    }
    
}
