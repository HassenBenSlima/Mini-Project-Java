package iit.election.isie.entities;

public class ElectionOffice {

	private Long idElectionOffice;
	private String name;
	private Long idElectionCentre;

	public ElectionOffice() {
		super();
	}

	public ElectionOffice(Long idElectionOffice, String name, Long idElectionCentre) {
		super();
		this.idElectionOffice = idElectionOffice;
		this.name = name;
		this.idElectionCentre = idElectionCentre;
	}

	public Long getIdElectionOffice() {
		return idElectionOffice;
	}

	public void setIdElectionOffice(Long idElectionOffice) {
		this.idElectionOffice = idElectionOffice;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getIdElectionCentre() {
		return idElectionCentre;
	}

	public void setIdElectionCentre(Long idElectionCentre) {
		this.idElectionCentre = idElectionCentre;
	}

}
