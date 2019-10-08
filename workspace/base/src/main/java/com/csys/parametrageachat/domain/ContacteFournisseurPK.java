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
public class ContacteFournisseurPK implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "fk_fournisseur_code", nullable = false, length = 10)
    private String fkFournisseurCode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fk_type_contacte_code", nullable = false)
    private int fkTypeContacteCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "valeur", nullable = false, length = 50)
    private String valeur;

    public ContacteFournisseurPK() {
    }

    public ContacteFournisseurPK(String fkFournisseurCode, int fkTypeContacteCode, String valeur) {
        this.fkFournisseurCode = fkFournisseurCode;
        this.fkTypeContacteCode = fkTypeContacteCode;
        this.valeur = valeur;
    }

    public String getFkFournisseurCode() {
        return fkFournisseurCode;
    }

    public void setFkFournisseurCode(String fkFournisseurCode) {
        this.fkFournisseurCode = fkFournisseurCode;
    }

    public int getFkTypeContacteCode() {
        return fkTypeContacteCode;
    }

    public void setFkTypeContacteCode(int fkTypeContacteCode) {
        this.fkTypeContacteCode = fkTypeContacteCode;
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
        hash += (fkFournisseurCode != null ? fkFournisseurCode.hashCode() : 0);
        hash += (int) fkTypeContacteCode;
        hash += (valeur != null ? valeur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContacteFournisseurPK)) {
            return false;
        }
        ContacteFournisseurPK other = (ContacteFournisseurPK) object;
        if ((this.fkFournisseurCode == null && other.fkFournisseurCode != null) || (this.fkFournisseurCode != null && !this.fkFournisseurCode.equals(other.fkFournisseurCode))) {
            return false;
        }
        if (this.fkTypeContacteCode != other.fkTypeContacteCode) {
            return false;
        }
        if ((this.valeur == null && other.valeur != null) || (this.valeur != null && !this.valeur.equals(other.valeur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csys.parametrageachat.domain.ContacteFournisseurPK[ fkFournisseurCode=" + fkFournisseurCode + ", fkTypeContacteCode=" + fkTypeContacteCode + ", valeur=" + valeur + " ]";
    }

}
