/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.parametrageachat.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//import com.csys.parametrageachat.dto.MaquetteDto;


/**
 *
 * @author Farouk
 */
@Entity
@Table(name = "departement")
public class Departement extends BaseEntity implements Serializable {

	@Basic(optional = false)
	@NotNull
	@Column(name = "fk_param_service_code")
	private int fkParamServiceCode;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 10)
	@Column(name = "code_saisi")
	private String codeSaisi;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "fkDepartementCode")
	private Collection<Depot> depotCollection;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "departement",orphanRemoval=true)
	private Collection<DepartementUser> departementUserCollection;


	public Collection<DepartementUser> getDepartementUserCollection() {
		return departementUserCollection;
	}

	public void setDepartementUserCollection(Collection<DepartementUser> departementUserCollection) {
		this.departementUserCollection = departementUserCollection;
	}

	@Transient
	private transient String[] categorieDepot;
	@Transient
	private transient String[] users;

	public String[] getUsers() {
		return users;
	}

	public void setUsers(String[] users) {
		this.users = users;
	}

/*	@Transient
	private transient MaquetteDto maquette;

	public MaquetteDto getMaquette() {
		return maquette;
	}

	public void setMaquette(MaquetteDto maquette) {
		this.maquette = maquette;
	}
*/
	public Departement() {
	}

	public int getFkParamServiceCode() {
		return fkParamServiceCode;
	}

	public void setFkParamServiceCode(int fkParamServiceCode) {
		this.fkParamServiceCode = fkParamServiceCode;
	}

	public String getCodeSaisi() {
		return codeSaisi;
	}

	public void setCodeSaisi(String codeSaisi) {
		this.codeSaisi = codeSaisi;
	}

	public Collection<Depot> getDepotCollection() {
		return depotCollection;
	}

	public void setDepotCollection(Collection<Depot> depotCollection) {
		this.depotCollection = depotCollection;
	}

	public String[] getCategorieDepot() {
		return categorieDepot;
	}

	public void setCategorieDepot(String[] categorieDepot) {
		this.categorieDepot = categorieDepot;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (super.getCode() != null ? super.getCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Departement)) {
			return false;
		}
		Departement other = (Departement) object;
		if ((super.getCode() == null && other.getCode() != null)
				|| (super.getCode() != null && !super.getCode().equals(other.getCode()))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.csys.parametrageachat.domain.Departement[ code=" + super.getCode() + " ]";
	}

}
