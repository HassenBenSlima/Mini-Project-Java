package tp2;

import java.io.Serializable;

public class CompteBank implements Serializable {

	int rib;
	String nomBank;

	public CompteBank(int rib, String nomBank) {

		this.rib = rib;
		this.nomBank = nomBank;
	}

	@Override
	public String toString() {
		return "CompteBank [rib=" + rib + ", nomBank=" + nomBank + "]";
	}

}
