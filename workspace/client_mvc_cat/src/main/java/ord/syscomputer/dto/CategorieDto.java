package ord.syscomputer.dto;

import java.util.Collection;

import com.querydsl.core.annotations.QueryProjection;

public class CategorieDto {

	private Long idCategorie;
	private String nomCategorie;
	private Collection<ProduitDTO> listProduitsDto;

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

	public Collection<ProduitDTO> getListProduitsDto() {
		return listProduitsDto;
	}

	public void setListProduitsDto(Collection<ProduitDTO> listProduitsDto) {
		this.listProduitsDto = listProduitsDto;
	}
	@QueryProjection
	public CategorieDto(Long idCategorie, String nomCategorie, Collection<ProduitDTO> listProduitsDto) {
		super();
		this.idCategorie = idCategorie;
		this.nomCategorie = nomCategorie;
		this.listProduitsDto = listProduitsDto;
	}

	public CategorieDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
