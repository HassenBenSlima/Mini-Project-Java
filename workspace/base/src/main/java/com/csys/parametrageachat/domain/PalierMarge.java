/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.parametrageachat.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Lenovo
 */
@Entity
@Table(name = "Palier_Marge")
@XmlRootElement
public class PalierMarge implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long num;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Du")
    private BigDecimal du;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Au")
    private BigDecimal au;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Marge")
    private BigDecimal marge;
    @Basic(optional = false)
    @JoinColumn(name = "Maquette", referencedColumnName = "code")
    @ManyToOne
    private Maquette maquette;

    public Maquette getMaquette() {
        return maquette;
    }

    public void setMaquette(Maquette maquette) {
        this.maquette = maquette;
    }

    public PalierMarge() {
    }

    public PalierMarge(Long num) {
        this.num = num;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public BigDecimal getDu() {
        return du;
    }

    public void setDu(BigDecimal du) {
        this.du = du;
    }

    public BigDecimal getAu() {
        return au;
    }

    public void setAu(BigDecimal au) {
        this.au = au;
    }

    public BigDecimal getMarge() {
        return marge;
    }

    public void setMarge(BigDecimal marge) {
        this.marge = marge;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (num != null ? num.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are
        // not set
        if (!(object instanceof PalierMarge)) {
            return false;
        }
        PalierMarge other = (PalierMarge) object;
        if ((this.num == null && other.num != null) || (this.num != null && !this.num.equals(other.num))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "helper.PalierMarge[ num=" + num + " ]";
    }

}
