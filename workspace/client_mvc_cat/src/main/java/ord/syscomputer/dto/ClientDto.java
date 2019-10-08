package ord.syscomputer.dto;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class ClientDto implements Serializable {

	private Long idClient;
	private String nomClient;
	private String adresse;
	private String email;
	private String tel;
	private Collection<CommandeDto> listCommandesDto;

	public Long getIdClient() {
		return idClient;
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}

	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
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

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Collection<CommandeDto> getListCommandesDto() {
		return listCommandesDto;
	}

	public void setListCommandesDto(Collection<CommandeDto> listCommandesDto) {
		this.listCommandesDto = listCommandesDto;
	}

}
