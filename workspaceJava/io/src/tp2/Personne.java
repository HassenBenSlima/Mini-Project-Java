package tp2;

import java.io.Serializable;
import java.util.Arrays;

public class Personne implements Serializable {

	int id;
	String nom;
	String prenom;

	String password;

	CompteBank[] banks;

	public Personne(int id, String nom, String prenom, String password, CompteBank[] banks) {

		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.password = password;
		this.banks = banks;
	}

	@Override
	public String toString() {
		return "Personne [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", password=" + password + ", banks="
				+ Arrays.toString(banks) + "]";
	}

}
