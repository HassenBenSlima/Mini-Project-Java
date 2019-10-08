/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.parametrageachat.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "nature_depot")
@NamedQueries({
    @NamedQuery(name = "NatureDepot.findAll", query = "SELECT n FROM NatureDepot n")})
public class NatureDepot implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NatureDepotPK natureDepotPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_principal")
    private boolean isPrincipal;
    @JoinColumn(name = "fk_categorie_depot_code", referencedColumnName = "code", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private CategorieDepot categorieDepot;
    @JsonBackReference
    @MapsId(value = "fkDepotCode")
    @JoinColumn(name = "fk_depot_code", referencedColumnName = "code")
    @ManyToOne(cascade = CascadeType.ALL)
    private Depot depot;

    public NatureDepot() {
    }

    public NatureDepot(NatureDepotPK natureDepotPK) {
        this.natureDepotPK = natureDepotPK;
    }

    public NatureDepot(NatureDepotPK natureDepotPK, boolean isPrincipal) {
        this.natureDepotPK = natureDepotPK;
        this.isPrincipal = isPrincipal;
    }

    public NatureDepot(int fkDepotCode, String fkCategorieDepotCode) {
        this.natureDepotPK = new NatureDepotPK(fkDepotCode, fkCategorieDepotCode);
    }

    public NatureDepotPK getNatureDepotPK() {
        return natureDepotPK;
    }

    public void setNatureDepotPK(NatureDepotPK natureDepotPK) {
        this.natureDepotPK = natureDepotPK;
    }

    public boolean getIsPrincipal() {
        return isPrincipal;
    }

    public void setIsPrincipal(boolean isPrincipal) {
        this.isPrincipal = isPrincipal;
    }

    public CategorieDepot getCategorieDepot() {
        return categorieDepot;
    }

    public void setCategorieDepot(CategorieDepot categorieDepot) {
        this.categorieDepot = categorieDepot;
    }

    public Depot getDepot() {
        return depot;
    }

    public void setDepot(Depot depot) {
        this.depot = depot;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (natureDepotPK != null ? natureDepotPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NatureDepot)) {
            return false;
        }
        NatureDepot other = (NatureDepot) object;
        if ((this.natureDepotPK == null && other.natureDepotPK != null) || (this.natureDepotPK != null && !this.natureDepotPK.equals(other.natureDepotPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.myapp.domain.NatureDepot[ natureDepotPK=" + natureDepotPK + " ]";
    }

}
