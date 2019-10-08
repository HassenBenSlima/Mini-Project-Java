/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.parametrageachat.domain;

import java.io.Serializable;

import javax.persistence.Basic;
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
import javax.validation.constraints.Size;

/**
 *
 * @author Lenovo
 */
@Entity
@Table(name = "piece_jointe_fournisseur")
@NamedQueries({
    @NamedQuery(name = "PieceJointeFournisseur.findAll", query = "SELECT p FROM PieceJointeFournisseur p")})
public class PieceJointeFournisseur implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PieceJointeFournisseurPK pieceJointeFournisseurPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valeur")
    private String valeur;
    @MapsId("fkfournisseurcode")
    @JoinColumn(name = "fk_fournisseur_code", referencedColumnName = "code", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Fournisseur fournisseur;
    @Basic(optional = false)
    @NotNull
    @Column(name = "type")
    private String type;

    public PieceJointeFournisseur() {
    }

    public PieceJointeFournisseur(PieceJointeFournisseurPK pieceJointeFournisseurPK) {
        this.pieceJointeFournisseurPK = pieceJointeFournisseurPK;
    }

    public PieceJointeFournisseur(PieceJointeFournisseurPK pieceJointeFournisseurPK, String valeur) {
        this.pieceJointeFournisseurPK = pieceJointeFournisseurPK;
        this.valeur = valeur;
    }

    public PieceJointeFournisseur(String fkFournisseurCode, int fkTypePieceJointe, String nom) {
        this.pieceJointeFournisseurPK = new PieceJointeFournisseurPK(fkFournisseurCode, nom);
    }

    public PieceJointeFournisseurPK getPieceJointeFournisseurPK() {
        return pieceJointeFournisseurPK;
    }

    public void setPieceJointeFournisseurPK(PieceJointeFournisseurPK pieceJointeFournisseurPK) {
        this.pieceJointeFournisseurPK = pieceJointeFournisseurPK;
    }

    public String getValeur() {
        return valeur;
    }

    public void setValeur(String valeur) {
        this.valeur = valeur;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pieceJointeFournisseurPK != null ? pieceJointeFournisseurPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are
        // not set
        if (!(object instanceof PieceJointeFournisseur)) {
            return false;
        }
        PieceJointeFournisseur other = (PieceJointeFournisseur) object;
        if ((this.pieceJointeFournisseurPK == null && other.pieceJointeFournisseurPK != null)
                || (this.pieceJointeFournisseurPK != null
                && !this.pieceJointeFournisseurPK.equals(other.pieceJointeFournisseurPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csys.parametrageachat.domain.PieceJointeFournisseur[ pieceJointeFournisseurPK="
                + pieceJointeFournisseurPK + " ]";
    }

}
