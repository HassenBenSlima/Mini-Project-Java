/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sid.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author K555L
 */
@Embeddable
public class RelationPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "code_art")
    private int codeArt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "code_commande")
    private int codeCommande;

    public RelationPK() {
    }

    public RelationPK(int codeArt, int codeCommande) {
        this.codeArt = codeArt;
        this.codeCommande = codeCommande;
    }

    public int getCodeArt() {
        return codeArt;
    }

    public void setCodeArt(int codeArt) {
        this.codeArt = codeArt;
    }

    public int getCodeCommande() {
        return codeCommande;
    }

    public void setCodeCommande(int codeCommande) {
        this.codeCommande = codeCommande;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codeArt;
        hash += (int) codeCommande;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RelationPK)) {
            return false;
        }
        RelationPK other = (RelationPK) object;
        if (this.codeArt != other.codeArt) {
            return false;
        }
        if (this.codeCommande != other.codeCommande) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csys.myproject.domain.RelationPK[ codeArt=" + codeArt + ", codeCommande=" + codeCommande + " ]";
    }
    
}
