package ma.fstm.ilisi.project.caisse.dto;

public abstract class DTOPaiement {
	private double total;
	private DTOVente vente;

	public DTOPaiement() {}
	
	public DTOPaiement(DTOVente v,double total) {
		this.vente = v;
		this.total = total;
	}
	
	

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public DTOVente getVente() {
		return vente;
	}

	public void setVente(DTOVente vente) {
		this.vente = vente;
	}

	abstract void payer(double somme);

}
