package ney.opendevup.entities;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
public class Gens implements Serializable{
	@Id
	private Long cin;
	@NotEmpty
	private String nom;
	@NotNull
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dateNaissance;
	@NotNull
	private Long age;
	@NotNull
	private Long telephone;
	@NotEmpty
	private String adresse;
	@NotEmpty
	@Email
	private String email;
	
	@OneToMany(mappedBy="gens")
	private Collection<Affectation> affectationGens;

	@ManyToOne
	@JoinColumn(name="idManicipalite")
	private Manicipalite manicipalite;
	

	@OneToMany(mappedBy="gensM")
	private Collection<AffectationMateriel> affectaionGensMtrl;
	@ManyToOne
	@JoinColumn(name="idType")
	private TypeGent gtsType;
	
	public Long getCin() {
		return cin;
	}

	public void setCin(Long cin) {
		this.cin = cin;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	public Long getTelephone() {
		return telephone;
	}

	public void setTelephone(Long telephone) {
		this.telephone = telephone;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public Collection<Affectation> getAffectationGens() {
		return affectationGens;
	}

	public void setAffectationGens(Collection<Affectation> affectationGens) {
		this.affectationGens = affectationGens;
	}

	public Manicipalite getManicipalite() {
		return manicipalite;
	}

	public void setManicipalite(Manicipalite manicipalite) {
		this.manicipalite = manicipalite;
	}

	public Collection<AffectationMateriel> getAffectaionGensMtrl() {
		return affectaionGensMtrl;
	}

	public void setAffectaionGensMtrl(Collection<AffectationMateriel> affectaionGensMtrl) {
		this.affectaionGensMtrl = affectaionGensMtrl;
	}

	public TypeGent getGtsType() {
		return gtsType;
	}

	public void setGtsType(TypeGent gtsType) {
		this.gtsType = gtsType;
	}

	public Gens() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Gens(Long cin, String nom, Date dateNaissance, Long age, Long telephone, String adresse, String email) {
		super();
		this.cin = cin;
		this.nom = nom;
		this.dateNaissance = dateNaissance;
		this.age = age;
		this.telephone = telephone;
		this.adresse = adresse;
		this.email = email;
	}

	public Gens(Long cin, String nom, Date dateNaissance, Long age, Long telephone, String adresse, String email,
			TypeGent gtsType,Manicipalite manicipalite) {
		super();
		this.cin = cin;
		this.nom = nom;
		this.dateNaissance = dateNaissance;
		this.age = age;
		this.telephone = telephone;
		this.adresse = adresse;
		this.email = email;
		this.manicipalite = manicipalite;
		this.gtsType = gtsType;
	}

	public Gens(Long cin) {
		super();
		this.cin = cin;
	}

	
	
	
	
}
