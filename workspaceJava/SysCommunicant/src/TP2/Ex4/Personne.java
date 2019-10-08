package TP2.Ex4;

import java.io.Serializable;
import java.util.Arrays;

public class Personne implements Serializable {

	public int id;
	public String nom;
	public String prenom;
	public String password;
	public CompteBank[] banks;

	public Personne(int id, String nom, String prenom, String password,CompteBank[] banks) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.password = password;
		this.banks=banks;
	}

	@Override
	public String toString() {
		return "Personne [id=" + id + ", nom=" + nom + "," + " prenom=" + prenom + ", password=" + password + "banks="
				+ Arrays.toString(banks) + "]";
	}

}
