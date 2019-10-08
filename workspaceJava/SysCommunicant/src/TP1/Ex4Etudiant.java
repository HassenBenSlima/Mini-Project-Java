package TP1;
import java.util.Scanner;

public class Ex4Etudiant {
	
	public String nom;
	public Long age;
	public double note;
	
	public Ex4Etudiant(String nom, Long age, double note) {
		super();
		this.nom = nom;
		this.age = age;
		this.note = note;
	}
	
	@Override
	public String toString() {
		return "Ex4Etudiant [nom=" + nom + ", age=" + age + ", note=" + note + "]";
	}
 
	public static void main(String[] args) {
		Scanner in =new Scanner(System.in);
		System.out.println("Nom: ");
		String nom = in.nextLine();
		System.out.println("Age: ");
		Long age = in.nextLong();
		System.out.println("Note: ");
		double note = in.nextDouble();

		in.close();//fermer le flux
		
		Ex4Etudiant et = new Ex4Etudiant(nom, age, note);
		Ex4Etudiant et2 = new Ex4Etudiant(nom, age, note);
		
		System.out.println(et.toString());
	}

}
