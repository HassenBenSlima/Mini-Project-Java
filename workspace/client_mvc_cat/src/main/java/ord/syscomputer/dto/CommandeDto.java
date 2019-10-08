package ord.syscomputer.dto;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

public class CommandeDto implements Serializable {

	private Long idCommande;
	private Date dateCommande;
	private Collection<LigneCommandeDto> listItemsDto;
	private ClientDto clientDto;

	public Long getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(Long idCommande) {
		this.idCommande = idCommande;
	}

	public Date getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

	public Collection<LigneCommandeDto> getListItemsDto() {
		return listItemsDto;
	}

	public void setListItemsDto(Collection<LigneCommandeDto> listItemsDto) {
		this.listItemsDto = listItemsDto;
	}

	public ClientDto getClientDto() {
		return clientDto;
	}

	public void setClientDto(ClientDto clientDto) {
		this.clientDto = clientDto;
	}

}
