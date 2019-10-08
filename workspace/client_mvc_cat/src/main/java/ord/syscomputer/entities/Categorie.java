package ord.syscomputer.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.querydsl.core.annotations.QueryProjection;

@Entity
public class Categorie implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCategorie;
	private String nomCategorie;
	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "categorie", fetch = FetchType.EAGER, orphanRemoval = true)
	/*
	 * Lazy :quant le framework d'objet relationnel hibernate va charger un
	 * categorie a partir d'un base de donnée il va charger que l'id et le nom
	 * de categorie
	 */
	private Collection<Produit> produits;

	public Long getIdCategorie() {
		return idCategorie;
	}

	public void setIdCategorie(Long idCategorie) {
		this.idCategorie = idCategorie;
	}

	public String getNomCategorie() {
		return nomCategorie;
	}

	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}

	public Collection<Produit> getProduits() {
		return produits;
	}

	public void setProduits(Collection<Produit> produits) {
		this.produits = produits;
	}
	
	public Categorie(String nomCategorie, Collection<Produit> produits) {
		super();
		this.nomCategorie = nomCategorie;
		this.produits = produits;
	}

	public Categorie(Long idCategorie) {
		super();
		this.idCategorie = idCategorie;
	}

	public Categorie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Categorie(String nomCategorie) {
		super();
		this.nomCategorie = nomCategorie;
	}

}
