package ma.fstm.ilisi.project.caisse.metier.bo;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Paiement implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idpaiement;
	private double total;
	@OneToOne
	@JoinColumn(name = "idvente")
	private Vente vente;

	public Paiement() {}
	public Paiement(Vente v,double total) {
		this.vente = v;
		this.total = total;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Vente getVente() {
		return vente;
	}

	public void setVente(Vente vente) {
		this.vente = vente;
	}

}
