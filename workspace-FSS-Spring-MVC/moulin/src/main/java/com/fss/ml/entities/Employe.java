package com.fss.ml.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Employe implements Serializable{
    
	@Id
	private Long cinEmp;
	@NotEmpty
	private String nomEmp;
	@NotEmpty
	private String prenomEmp;
	@NotNull
	private Long telEmp;
	@NotEmpty
	private String adrEmp;
	private String grade;
	private String periode;
	
	
	@OneToMany
	//quant l'aasociation n'est pas bidirectionnel
	//la clé étranger vous allez la spécifier ici
	@JoinColumn(name="cinEmp")// avec la cle de user
	private Collection<Role> roles;
	
	

	public Collection<Role> getRoles() {
		return roles;
	}


	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}


	public Long getCinEmp() {
		return cinEmp;
	}


	public void setCinEmp(Long cinEmp) {
		this.cinEmp = cinEmp;
	}


	public String getNomEmp() {
		return nomEmp;
	}


	public void setNomEmp(String nomEmp) {
		this.nomEmp = nomEmp;
	}


	public String getPrenomEmp() {
		return prenomEmp;
	}


	public void setPrenomEmp(String prenomEmp) {
		this.prenomEmp = prenomEmp;
	}


	public Long getTelEmp() {
		return telEmp;
	}


	public void setTelEmp(Long telEmp) {
		this.telEmp = telEmp;
	}


	public String getAdrEmp() {
		return adrEmp;
	}


	public void setAdrEmp(String adrEmp) {
		this.adrEmp = adrEmp;
	}


	public String getGrade() {
		return grade;
	}


	public void setGrade(String grade) {
		this.grade = grade;
	}


	public String getPeriode() {
		return periode;
	}


	public void setPeriode(String periode) {
		this.periode = periode;
	}




	public Employe(Long cinEmp, String nomEmp, String prenomEmp, Long telEmp, String adrEmp, String grade,
			String periode) {
		super();
		this.cinEmp = cinEmp;
		this.nomEmp = nomEmp;
		this.prenomEmp = prenomEmp;
		this.telEmp = telEmp;
		this.adrEmp = adrEmp;
		this.grade = grade;
		this.periode = periode;
	}


	public Employe() {
		super();
		// TODO Auto-generated constructor stub
	}



		
	
}
