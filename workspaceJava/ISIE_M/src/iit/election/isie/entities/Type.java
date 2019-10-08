package iit.election.isie.entities;

public class Type {
	private int id;
	private String job;

	public Type() {
	}

	public Type(int id, String job) {
		super();
		this.id = id;
		this.job = job;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

}
