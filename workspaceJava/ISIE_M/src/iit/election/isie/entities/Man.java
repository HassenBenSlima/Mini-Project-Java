package iit.election.isie.entities;

public class Man {

	private Long cin;
	private String name;
	private String lastname;
	private String NameAndLastname;
	private Long phone1;
	private Long phone2;
	private byte[] image;
	private Long idManicipality;
	private Long idType;
	private Long idElectionOffice;

	public Man() {
	}

	public Man(Long cin, String name, String lastname, String nameAndLastname, Long phone1, Long phone2,
			Long idManicipality) {
		super();
		this.cin = cin;
		this.name = name;
		this.lastname = lastname;
		NameAndLastname = nameAndLastname;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.idManicipality = idManicipality;
	}

	public Long getCin() {
		return cin;
	}

	public void setCin(Long cin) {
		this.cin = cin;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getNameAndLastname() {
		return NameAndLastname;
	}

	public void setNameAndLastname(String nameAndLastname) {
		NameAndLastname = nameAndLastname;
	}

	public Long getPhone1() {
		return phone1;
	}

	public void setPhone1(Long phone1) {
		this.phone1 = phone1;
	}

	public Long getPhone2() {
		return phone2;
	}

	public void setPhone2(Long phone2) {
		this.phone2 = phone2;
	}

	public Long getIdManicipality() {
		return idManicipality;
	}

	public void setIdManicipality(Long idManicipality) {
		this.idManicipality = idManicipality;
	}

	public Long getIdType() {
		return idType;
	}

	public void setIdType(Long idType) {
		this.idType = idType;
	}

	public Long getIdElectionOffice() {
		return idElectionOffice;
	}

	public void setIdElectionOffice(Long idElectionOffice) {
		this.idElectionOffice = idElectionOffice;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
	

}
