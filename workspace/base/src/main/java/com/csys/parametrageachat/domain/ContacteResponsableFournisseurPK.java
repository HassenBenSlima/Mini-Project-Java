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
import javax.validation.constraints.Size;

/**
 *
 * @author Lenovo
 */
@Embeddable
public class ContacteResponsableFournisseurPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "fk_responsable_fournisseur_code", nullable = false)
    private int fkResponsableFournisseurCode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fk_param_type_contacte_code", nullable = false)
    private int fkParamTypeContacteCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "valeur", nullable = false, length = 50)
    private String valeur;

    public ContacteResponsableFournisseurPK() {
    }

    public ContacteResponsableFournisseurPK(int fkResponsableFournisseurCode, int fkParamTypeContacteCode, String valeur) {
        this.fkResponsableFournisseurCode = fkResponsableFournisseurCode;
        this.fkParamTypeContacteCode = fkParamTypeContacteCode;
        this.valeur = valeur;
    }

    public int getFkResponsableFournisseurCode() {
        return fkResponsableFournisseurCode;
    }

    public void setFkResponsableFournisseurCode(int fkResponsableFournisseurCode) {
        this.fkResponsableFournisseurCode = fkResponsableFournisseurCode;
    }

    public int getFkParamTypeContacteCode() {
        return fkParamTypeContacteCode;
    }

    public void setFkParamTypeContacteCode(int fkParamTypeContacteCode) {
        this.fkParamTypeContacteCode = fkParamTypeContacteCode;
    }

    public String getValeur() {
        return valeur;
    }

    public void setValeur(String valeur) {
        this.valeur = valeur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) fkResponsableFournisseurCode;
        hash += (int) fkParamTypeContacteCode;
        hash += (valeur != null ? valeur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContacteResponsableFournisseurPK)) {
            return false;
        }
        ContacteResponsableFournisseurPK other = (ContacteResponsableFournisseurPK) object;
        if (this.fkResponsableFournisseurCode != other.fkResponsableFournisseurCode) {
            return false;
        }
        if (this.fkParamTypeContacteCode != other.fkParamTypeContacteCode) {
            return false;
        }
        if ((this.valeur == null && other.valeur != null) || (this.valeur != null && !this.valeur.equals(other.valeur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csys.parametrageachat.domain.ContacteResponsableFournisseurPK[ fkResponsableFournisseurCode=" + fkResponsableFournisseurCode + ", fkParamTypeContacteCode=" + fkParamTypeContacteCode + ", valeur=" + valeur + " ]";
    }

}
