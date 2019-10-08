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
public class PieceJointeFournisseurPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "fk_fournisseur_code")
    private String fkFournisseurCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "nom")
    private String nom;

    public PieceJointeFournisseurPK() {
    }

    public PieceJointeFournisseurPK(String fkFournisseurCode, String nom) {
        this.fkFournisseurCode = fkFournisseurCode;
        this.nom = nom;
    }

    public String getFkFournisseurCode() {
        return fkFournisseurCode;
    }

    public void setFkFournisseurCode(String fkFournisseurCode) {
        this.fkFournisseurCode = fkFournisseurCode;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fkFournisseurCode != null ? fkFournisseurCode.hashCode() : 0);
        hash += (nom != null ? nom.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are
        // not set
        if (!(object instanceof PieceJointeFournisseurPK)) {
            return false;
        }
        PieceJointeFournisseurPK other = (PieceJointeFournisseurPK) object;
        if ((this.fkFournisseurCode == null && other.fkFournisseurCode != null)
                || (this.fkFournisseurCode != null && !this.fkFournisseurCode.equals(other.fkFournisseurCode))) {
            return false;
        }

        if ((this.nom == null && other.nom != null) || (this.nom != null && !this.nom.equals(other.nom))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csys.parametrageachat.domain.PieceJointeFournisseurPK[ fkFournisseurCode=" + fkFournisseurCode
                + ", nom=" + nom + " ]";
    }

}
