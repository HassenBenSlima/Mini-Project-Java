package ord.syscomputer.entities;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.springframework.util.Assert;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.querydsl.core.annotations.QueryProjection;

@Entity
public class Produit implements Serializable{
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String designation;
	private double prix;
//	private boolean selected;

	private int quantite;
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="idCategorie")
	private Categorie categorie;
	
	public Produit() {
		super();
	}
	public Produit(String designation, double prix, int quantite) {
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
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
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
	  
	public Produit(String designation, double prix, int quantite, Categorie categorie) {
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
