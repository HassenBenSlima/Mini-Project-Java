package tn.iit.servlet;

import java.util.ArrayList;

public class User {
	private String nom;
	private String prenom;
	private String login;
	private String pswd;
 
	@Override
	public String toString() {
		return "User [nom=" + nom + ", prenom=" + prenom + ", login=" + login + ", pswd=" + pswd + "]";
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPswd() {
		return pswd;
	}

	public void setPswd(String pswd) {
		this.pswd = pswd;
	}

	public User(String nom, String prenom, String login, String pswd) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.pswd = pswd;
	}
	 
	}

	 



