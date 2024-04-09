package ma.fstm.ilisi.project.caisse.dto;


public class DTOLigneAchat {
	private DTOProduit produit;
	private int quantite;
	private double sousTotal;
	private DTOVente vente;
	
	
	public DTOLigneAchat(DTOProduit produit, int quantite, double sousTotal) {
		super();
		this.produit = produit;
		this.quantite = quantite;
		this.sousTotal = sousTotal;
	}
	
	public DTOLigneAchat(DTOProduit produit, int quantite, double sousTotal,DTOVente vente) {
		super();
		this.produit = produit;
		this.quantite = quantite;
		this.sousTotal = sousTotal;
		this.vente = vente;
	}
	
	

	public DTOLigneAchat(DTOProduit produit, DTOVente vente) {
		super();
		this.produit = produit;
		this.quantite = 1;
		this.sousTotal = produit.getPrix();
		this.vente = vente;
	}

	public DTOProduit getProduit() {
		return produit;
	}

	public void setProduit(DTOProduit produit) {
		this.produit = produit;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public double getSousTotal() {
		return sousTotal;
	}

	public void setSousTotal(double sousTotal) {
		this.sousTotal = sousTotal;
	}

	public DTOVente getVente() {
		return vente;
	}

	public void setVente(DTOVente vente) {
		this.vente = vente;
	}
	
	

}
