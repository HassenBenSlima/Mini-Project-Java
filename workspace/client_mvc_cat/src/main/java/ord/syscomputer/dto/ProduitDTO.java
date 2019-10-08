package ord.syscomputer.dto;

import javax.jdo.annotations.PersistenceCapable;

import org.springframework.data.rest.core.config.Projection;

import com.querydsl.core.annotations.Config;
import com.querydsl.core.annotations.QueryEmbeddable;
import com.querydsl.core.annotations.QueryEntities;
import com.querydsl.core.annotations.QueryEntity;
import com.querydsl.core.annotations.QueryInit;
import com.querydsl.core.annotations.QueryProjection;
import ord.syscomputer.entities.Produit;

//@PersistenceCapable
//@Config(entityAccessors=true)
@Projection(name = "ProduitDTO", types = Produit.class)
public class ProduitDTO {

	private Long idDTO;
	private String designation;
	private double prix;
	private int quantite;
	private CategorieDto categorieDto;

	
	public Long getIdDTO() {
		return idDTO;
	}

	public void setIdDTO(Long idDTO) {
		this.idDTO = idDTO;
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

	public CategorieDto getCategorieDto() {
		return categorieDto;
	}

	public void setCategorieDto(CategorieDto categorieDto) {
		this.categorieDto = categorieDto;
	}
	@QueryProjection
	public ProduitDTO(Long idDTO, String designation, double prix, int quantite, CategorieDto categorieDto) {
		super();
		this.idDTO = idDTO;
		this.designation = designation;
		this.prix = prix;
		this.quantite = quantite;
		this.categorieDto = categorieDto;
	}
	@QueryProjection
	public ProduitDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	  
	  
	
	

}
