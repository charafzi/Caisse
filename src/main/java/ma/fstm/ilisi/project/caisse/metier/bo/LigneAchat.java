package ma.fstm.ilisi.project.caisse.metier.bo;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class LigneAchat implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@ManyToOne
	@JoinColumn(name="code")
	private Produit produit;
	private int quantite;
	private double sousTotal;
	@ManyToOne
	@JoinColumn(name="idvente")
	private Vente vente;
	
	LigneAchat(){}
	
	public LigneAchat(int id, Produit produit, int quantite, double sousTotal, Vente vente) {
		super();
		this.id = id;
		this.produit = produit;
		this.quantite = quantite;
		this.sousTotal = sousTotal;
		this.vente = vente;
	}
	
	public LigneAchat(Produit produit, int quantite, double sousTotal, Vente vente) {
		super();
		this.produit = produit;
		this.quantite = quantite;
		this.sousTotal = sousTotal;
		this.vente = vente;
	}
	
	public LigneAchat(Produit produit, int quantite, double sousTotal) {
		super();
		this.produit = produit;
		this.quantite = quantite;
		this.sousTotal = sousTotal;
	}

	public LigneAchat(int id) 
	{
		this.id = id;
		this.quantite = 1;
		this.sousTotal = 1 *  produit.getPrix();
	}
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
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

	public Vente getVente() {
		return vente;
	}

	public void setVente(Vente vente) {
		this.vente = vente;
	}
	
	
	
	

}
