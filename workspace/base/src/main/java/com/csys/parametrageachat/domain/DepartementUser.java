/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.parametrageachat.domain;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Lenovo
 */
@Entity
@Table(name = "departement_user")
public class DepartementUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DepartementUserPK departementUserPK;
    
    @MapsId("fkDepartementCode")
    @JoinColumn(name = "fk_departement_code", referencedColumnName = "code", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Departement departement;
    

    public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	public DepartementUser() {
    }

    public DepartementUser(DepartementUserPK DepartementUserPK) {
        this.departementUserPK = DepartementUserPK;
    }

    public DepartementUser(int fkDepartementCode, String username) {
        this.departementUserPK = new DepartementUserPK(fkDepartementCode, username);
    }

    public DepartementUserPK getDepartementUserPK() {
        return departementUserPK;
    }

    public void setDepartementUserPK(DepartementUserPK DepartementUserPK) {
        this.departementUserPK = DepartementUserPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (departementUserPK != null ? departementUserPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DepartementUser)) {
            return false;
        }
        DepartementUser other = (DepartementUser) object;
        if ((this.departementUserPK == null && other.departementUserPK != null) || (this.departementUserPK != null && !this.departementUserPK.equals(other.departementUserPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.csys.parametrageachat.domain.DepartementUsers[ departementUserPK=" + departementUserPK + " ]";
    }
    
}
