package iit.election.isie.entities;

public class ElectionCentre {
	private Long idElectionCentre;
	private String name;
	private Long nombreInscribed;
	private Long idManicipality;

	public ElectionCentre(Long idElectionCentre, String name, Long nombreInscribed, Long idManicipality) {
		super();
		this.idElectionCentre = idElectionCentre;
		this.name = name;
		this.nombreInscribed = nombreInscribed;
		this.idManicipality = idManicipality;
	}

	public ElectionCentre() {
		super();
	}

	public Long getIdElectionCentre() {
		return idElectionCentre;
	}

	public void setIdElectionCentre(Long idElectionCentre) {
		this.idElectionCentre = idElectionCentre;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getNombreInscribed() {
		return nombreInscribed;
	}

	public void setNombreInscribed(Long nombreInscribed) {
		this.nombreInscribed = nombreInscribed;
	}

	public Long getIdManicipality() {
		return idManicipality;
	}

	public void setIdManicipality(Long idManicipality) {
		this.idManicipality = idManicipality;
	}

}
