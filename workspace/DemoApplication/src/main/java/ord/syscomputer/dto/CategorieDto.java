package ord.syscomputer.dto;

import java.util.Collection;

import javax.validation.constraints.NotNull;


public class CategorieDto {
	
	private Long idCategorie;
	@NotNull
	private String nomCategorie;
	
	private Collection<ProduitDto> listProduitsDto;
	
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
	
	public Collection<ProduitDto> getListProduitsDto() {
		return listProduitsDto;
	}
	public void setListProduitsDto(Collection<ProduitDto> listProduitsDto) {
		this.listProduitsDto = listProduitsDto;
	}


	
	

	

	
}
