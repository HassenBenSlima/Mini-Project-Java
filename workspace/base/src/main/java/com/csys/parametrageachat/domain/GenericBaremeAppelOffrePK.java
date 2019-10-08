/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.parametrageachat.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Farouk
 */
@Embeddable
public class GenericBaremeAppelOffrePK implements Serializable {

    private static final long serialVersionUID = 1L;

    @Basic(optional = false)
    @NotNull
    @Column(name = "fk_generic_code")
    private Integer fkGenericCode;

    @Basic(optional = false)
    @Column(name = "fk_bareme_appel_offre")
    private int fkBaremeAppelOffre;

    public GenericBaremeAppelOffrePK() {
    }

    public GenericBaremeAppelOffrePK(Integer fkGenericCode, int fkBaremeAppelOffre) {
        this.fkGenericCode = fkGenericCode;
        this.fkBaremeAppelOffre = fkBaremeAppelOffre;
    }

    public Integer getFkGenericCode() {
        return fkGenericCode;
    }

    public void setFkGenericCode(Integer fkGenericCode) {
        this.fkGenericCode = fkGenericCode;
    }

    public int getFkBaremeAppelOffre() {
        return fkBaremeAppelOffre;
    }

    public void setFkBaremeAppelOffre(int fkBaremeAppelOffre) {
        this.fkBaremeAppelOffre = fkBaremeAppelOffre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) fkGenericCode;
        hash += (int) fkBaremeAppelOffre;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GenericBaremeAppelOffrePK)) {
            return false;
        }
        GenericBaremeAppelOffrePK other = (GenericBaremeAppelOffrePK) object;
        if (this.fkGenericCode != other.fkGenericCode) {
            return false;
        }
        if (this.fkBaremeAppelOffre != other.fkBaremeAppelOffre) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csys.parametrageachat.domain.GenericBaremeAppelOffrePK[ fkGenericCode=" + fkGenericCode + ", fkBaremeAppelOffre=" + fkBaremeAppelOffre + " ]";
    }

}
