package ma.fstm.ilisi.project.caisse.metier.bo;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Vente implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private int idvente;
	@Column(name="venteDate")
	private LocalDate date;
	private double total;
	private boolean termine;
	@OneToMany(mappedBy = "vente",fetch = FetchType.LAZY)
	private List<LigneAchat> lgAchats;
	@OneToOne(mappedBy = "vente")
	private Paiement paiement;

	
	
	public Vente() 
	{

	}
		
	public Vente(LocalDate date, double total, boolean termine) {
		super();
		
		this.date = date;
		this.total = total;
		this.termine = termine;
	}

	
	public int getIdVente() {
		return idvente;
	}



	public void setIdVente(int idVente) {
		this.idvente = idVente;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public boolean isTermine() {
		return termine;
	}

	public void setTermine(boolean termine) {
		this.termine = termine;
	}
	
	public List<LigneAchat> getLgAchats() {
		return lgAchats;
	}

	public void setLgAchats(List<LigneAchat> lgAchats) {
		this.lgAchats = lgAchats;
	}

	public Paiement getPaiement() {
		return paiement;
	}

	public void setPaiement(Paiement paiement) {
		this.paiement = paiement;
	}

	@Override
	public String toString() {
		return "[ Vente : id = "+this.idvente+", Date ="+this.date.toString()+"]";
	}


	public double totalLgAchat() {
		double total=0;
		for(LigneAchat lg:lgAchats)
			total+=lg.getSousTotal();
		return total;
	}

	public double getTotal() {
		return this.total;
	}


	public void setTotal(double total) {
		this.total = total;
	}

}
