package ord.syscomputer.dto;

import java.math.BigDecimal;

public class ProduitDto {

	private Long id;
	private String designation;
	private BigDecimal prix;
	
	private int quantite;
	private String categorieDto;
	
	
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
	public String getCategorieDto() {
		return categorieDto;
	}
	public void setCategorieDto(String categorieDto) {
		this.categorieDto = categorieDto;
	}
	
	
}
