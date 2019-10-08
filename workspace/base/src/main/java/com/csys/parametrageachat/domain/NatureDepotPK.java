/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.parametrageachat.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Farouk
 */
@Embeddable
public class NatureDepotPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "fk_depot_code")
    private int fkDepotCode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fk_categorie_depot_code")
    private String fkCategorieDepotCode;

    public NatureDepotPK() {
    }

    public NatureDepotPK(int fkDepotCode, String fkCategorieDepotCode) {
        this.fkDepotCode = fkDepotCode;
        this.fkCategorieDepotCode = fkCategorieDepotCode;
    }

    public int getFkDepotCode() {
        return fkDepotCode;
    }

    public void setFkDepotCode(int fkDepotCode) {
        this.fkDepotCode = fkDepotCode;
    }

    public String getFkCategorieDepotCode() {
        return fkCategorieDepotCode;
    }

    public void setFkCategorieDepotCode(String fkCategorieDepotCode) {
        this.fkCategorieDepotCode = fkCategorieDepotCode;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NatureDepotPK)) {
            return false;
        }
        NatureDepotPK other = (NatureDepotPK) object;
        if (this.fkDepotCode != other.fkDepotCode) {
            return false;
        }
        if (this.fkCategorieDepotCode != other.fkCategorieDepotCode) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.fkDepotCode;
        hash = 67 * hash + Objects.hashCode(this.fkCategorieDepotCode);
        return hash;
    }

    @Override
    public String toString() {
        return "com.mycompany.myapp.domain.NatureDepotPK[ fkDepotCode=" + fkDepotCode + ", fkCategorieDepotCode=" + fkCategorieDepotCode + " ]";
    }

}
