/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.parametrageachat.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


/**
 *
 * @author Farouk
 */
@Entity
@Table(name = "generic_bareme_appel_offre")
@NamedQueries({
    @NamedQuery(name = "GenericBaremeAppelOffre.findAll", query = "SELECT g FROM GenericBaremeAppelOffre g")})
public class GenericBaremeAppelOffre implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GenericBaremeAppelOffrePK genericBaremeAppelOffrePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "note")
    private int note;
    @JoinColumn(name = "fk_bareme_appel_offre", referencedColumnName = "code", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private BaremeAppelOffre baremeAppelOffre;
    @MapsId(value = "fkGenericCode")
    @JoinColumn(name = "fk_generic_code", referencedColumnName = "code")
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private Generic generic;

    public GenericBaremeAppelOffre() {
    }

    public GenericBaremeAppelOffre(GenericBaremeAppelOffrePK genericBaremeAppelOffrePK) {
        this.genericBaremeAppelOffrePK = genericBaremeAppelOffrePK;
    }

    public GenericBaremeAppelOffre(GenericBaremeAppelOffrePK genericBaremeAppelOffrePK, int note) {
        this.genericBaremeAppelOffrePK = genericBaremeAppelOffrePK;
        this.note = note;
    }

    public GenericBaremeAppelOffre(int fkGenericCode, int fkBaremeAppelOffre) {
        this.genericBaremeAppelOffrePK = new GenericBaremeAppelOffrePK(fkGenericCode, fkBaremeAppelOffre);
    }

    public GenericBaremeAppelOffrePK getGenericBaremeAppelOffrePK() {
        return genericBaremeAppelOffrePK;
    }

    public void setGenericBaremeAppelOffrePK(GenericBaremeAppelOffrePK genericBaremeAppelOffrePK) {
        this.genericBaremeAppelOffrePK = genericBaremeAppelOffrePK;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public BaremeAppelOffre getBaremeAppelOffre() {
        return baremeAppelOffre;
    }

    public void setBaremeAppelOffre(BaremeAppelOffre baremeAppelOffre) {
        this.baremeAppelOffre = baremeAppelOffre;
    }

    public Generic getGeneric() {
        return generic;
    }

    public void setGeneric(Generic generic) {
        this.generic = generic;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (genericBaremeAppelOffrePK != null ? genericBaremeAppelOffrePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GenericBaremeAppelOffre)) {
            return false;
        }
        GenericBaremeAppelOffre other = (GenericBaremeAppelOffre) object;
        if ((this.genericBaremeAppelOffrePK == null && other.genericBaremeAppelOffrePK != null) || (this.genericBaremeAppelOffrePK != null && !this.genericBaremeAppelOffrePK.equals(other.genericBaremeAppelOffrePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csys.parametrageachat.domain.GenericBaremeAppelOffre[ genericBaremeAppelOffrePK=" + genericBaremeAppelOffrePK + " ]";
    }

}
