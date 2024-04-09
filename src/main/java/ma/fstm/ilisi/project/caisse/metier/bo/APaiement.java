package ma.fstm.ilisi.project.caisse.metier.bo;

import java.io.Serializable;

abstract class APaiement implements Serializable{
	private Vente vente;
	private double total;

	
	
	public APaiement(Vente vente, double total) {
		super();
		this.vente = vente;
		this.total = total;
	}



	abstract void payer(double somme);

}
