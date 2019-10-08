package ord.syscomputer.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.springframework.util.Assert;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
public class Produit implements Serializable{
	@Id @GeneratedValue
	private Long id;
	private String designation;
	private BigDecimal prix;
	private int quantite;
	@JsonBackReference
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idCategorie")
	private Categorie categorie;
	
	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Produit(String designation, BigDecimal prix, int quantite) {
		super();
		Assert.hasLength(designation, "designation must not be empty");
		this.designation = designation;
		this.prix = prix;
		this.quantite = quantite;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public BigDecimal getPrix() {
		return prix;
	}
	public void setPrix(BigDecimal prix) {
		this.prix = prix;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public Produit(String designation, BigDecimal prix, int quantite, Categorie categorie) {
		super();
		this.designation = designation;
		this.prix = prix;
		this.quantite = quantite;
		this.categorie = categorie;
	}
	public Produit(Long id) {
		super();
		this.id = id;
	}

	
}
