package com.csys.parametrageachat.domain;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Maquette")
public class Maquette implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@Column(name = "code")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer code;

	@Column(name = "designation")
	private String designation;

	@Column(name = "generale")
	private Boolean generale;

	@OneToMany(mappedBy = "maquette", cascade = CascadeType.ALL,orphanRemoval=true)
	private Collection<PalierMarge> palierMarge;

	@OneToMany(mappedBy = "maquette")
	private Collection<Depot> depots;

	public Maquette() {

	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Collection<PalierMarge> getPalierMarge() {
		return palierMarge;
	}

	public void setPalierMarge(Collection<PalierMarge> palierMarge) {
		this.palierMarge = palierMarge;
	}

	public Collection<Depot> getDepots() {
		return depots;
	}

	public void setDepots(Collection<Depot> depots) {
		this.depots = depots;
	}

	public Boolean getGenerale() {
		return generale;
	}

	public void setGenerale(Boolean generale) {
		this.generale = generale;
	}

}
