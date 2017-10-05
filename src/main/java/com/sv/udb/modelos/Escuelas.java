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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "escuelas", catalog = "vasoleche", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Escuelas.findAll", query = "SELECT e FROM Escuelas e")
    , @NamedQuery(name = "Escuelas.findByCodiEscu", query = "SELECT e FROM Escuelas e WHERE e.codiEscu = :codiEscu")
    , @NamedQuery(name = "Escuelas.findByNombDire", query = "SELECT e FROM Escuelas e WHERE e.nombDire = :nombDire")
    , @NamedQuery(name = "Escuelas.findByNombEscu", query = "SELECT e FROM Escuelas e WHERE e.nombEscu = :nombEscu")
    , @NamedQuery(name = "Escuelas.findByCantAlum", query = "SELECT e FROM Escuelas e WHERE e.cantAlum = :cantAlum")
    , @NamedQuery(name = "Escuelas.findByCantEntr", query = "SELECT e FROM Escuelas e WHERE e.cantEntr = :cantEntr")
    , @NamedQuery(name = "Escuelas.findByEstaEscu", query = "SELECT e FROM Escuelas e WHERE e.estaEscu = :estaEscu")})
public class Escuelas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codi_escu")
    private Integer codiEscu;
    @Basic(optional = false)
    @Size(min = 1, max = 150)
    @Column(name = "nomb_dire")
    private String nombDire;
    @Basic(optional = false)
    @Size(min = 1, max = 150)
    @Column(name = "nomb_escu")
    private String nombEscu;
    @Basic(optional = false)
    @Column(name = "cant_alum")
    private int cantAlum;
    @Basic(optional = false)
    @Column(name = "cant_entr")
    private int cantEntr;
    @Basic(optional = false)
    @Column(name = "esta_escu")
    private int estaEscu;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codiEscu", fetch = FetchType.LAZY)
    private List<Leche> lecheList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codiEscu", fetch = FetchType.LAZY)
    private List<Entregas> entregasList;
    @JoinColumn(name = "codi_depa", referencedColumnName = "codi_depa")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Departamentos codiDepa;
    @JoinColumn(name = "codi_unid", referencedColumnName = "codi_unid")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private UnidadesMedidas codiUnid;

    public Escuelas() {
    }

    public Escuelas(Integer codiEscu) {
        this.codiEscu = codiEscu;
    }

    public Escuelas(Integer codiEscu, String nombDire, String nombEscu, int cantAlum, int cantEntr, int estaEscu) {
        this.codiEscu = codiEscu;
        this.nombDire = nombDire;
        this.nombEscu = nombEscu;
        this.cantAlum = cantAlum;
        this.cantEntr = cantEntr;
        this.estaEscu = estaEscu;
    }

    public Integer getCodiEscu() {
        return codiEscu;
    }

    public void setCodiEscu(Integer codiEscu) {
        this.codiEscu = codiEscu;
    }

    public String getNombDire() {
        return nombDire;
    }

    public void setNombDire(String nombDire) {
        this.nombDire = nombDire;
    }

    public String getNombEscu() {
        return nombEscu;
    }

    public void setNombEscu(String nombEscu) {
        this.nombEscu = nombEscu;
    }

    public int getCantAlum() {
        return cantAlum;
    }

    public void setCantAlum(int cantAlum) {
        this.cantAlum = cantAlum;
    }

    public int getCantEntr() {
        return cantEntr;
    }

    public void setCantEntr(int cantEntr) {
        this.cantEntr = cantEntr;
    }

    public int getEstaEscu() {
        return estaEscu;
    }

    public void setEstaEscu(int estaEscu) {
        this.estaEscu = estaEscu;
    }

    @XmlTransient
    public List<Leche> getLecheList() {
        return lecheList;
    }

    public void setLecheList(List<Leche> lecheList) {
        this.lecheList = lecheList;
    }

    @XmlTransient
    public List<Entregas> getEntregasList() {
        return entregasList;
    }

    public void setEntregasList(List<Entregas> entregasList) {
        this.entregasList = entregasList;
    }

    public Departamentos getCodiDepa() {
        return codiDepa;
    }

    public void setCodiDepa(Departamentos codiDepa) {
        this.codiDepa = codiDepa;
    }

    public UnidadesMedidas getCodiUnid() {
        return codiUnid;
    }

    public void setCodiUnid(UnidadesMedidas codiUnid) {
        this.codiUnid = codiUnid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codiEscu != null ? codiEscu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Escuelas)) {
            return false;
        }
        Escuelas other = (Escuelas) object;
        if ((this.codiEscu == null && other.codiEscu != null) || (this.codiEscu != null && !this.codiEscu.equals(other.codiEscu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.udb.modelos.Escuelas[ codiEscu=" + codiEscu + " ]";
    }
    
}
