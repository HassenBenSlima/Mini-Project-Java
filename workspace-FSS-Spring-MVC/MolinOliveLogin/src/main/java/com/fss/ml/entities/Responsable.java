package com.fss.ml.entities;


import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Table;


@Entity
@Table(name="users")
public class Responsable extends Employe{

	@Column(name="user_name")
	private String userName;
	private String password;
	private boolean actived;

	
	
	
	
	public boolean isActived() {
		return actived;
	}

	public void setActived(boolean actived) {
		this.actived = actived;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public Responsable(Long cinEmp, String nomEmp, String prenomEmp, Long telEmp, String adrEmp, String grade,
			String periode, String userName, String password, boolean actived) {
		super(cinEmp, nomEmp, prenomEmp, telEmp, adrEmp, grade, periode);
		this.userName = userName;
		this.password = password;
		this.actived = actived;
	}

	public Responsable() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
		
	
}
