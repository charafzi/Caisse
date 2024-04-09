package ma.fstm.ilisi.project.caisse.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;

import ma.fstm.ilisi.project.caisse.metier.service.PaiementService;
import ma.fstm.ilisi.project.caisse.metier.service.VenteService;

public class DTOVente {
	private LocalDate date;
	private double total;
	private boolean termine;
	private List<DTOLigneAchat> lgAchats = new ArrayList<>();
	private DTOPaiement paiement;
	
	public DTOVente() {}
	
	public DTOVente(LocalDate date)
	{
		this.date = date;
	}
	
	public DTOVente(LocalDate date, double total, boolean termine) 
	{
		super();
		this.date = date;
		this.total = total;
		this.termine = termine;
		
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
		this.termine = false;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public boolean isTermine() {
		return termine;
	}

	public void setTermine(boolean termine) {
		this.termine = termine;
	}

	public List<DTOLigneAchat> getLgAchats() {
		return lgAchats;
	}

	public void setLgAchats(List<DTOLigneAchat> lgAchats) {
		this.lgAchats = lgAchats;
	}

	public DTOPaiement getPaiement() {
		return paiement;
	}

	public void setPaiement(DTOPaiement paiement) {
		this.paiement = paiement;
	}
	
	public void ajouterArticle(DTOProduit p)
	{	
    	//creer ligne de vente
        DTOLigneAchat lg = new DTOLigneAchat(p,this);
        
        //ajout de la ligne de vente à vente 
    	this.lgAchats.add(lg);       
	}
	
	public DTOLigneAchat getLastLigneAchat()
	{
		return this.lgAchats.getLast();
	}
	
	public double totalLgAchat() {
		double total=0;
		for(DTOLigneAchat lg:lgAchats)
			total+=lg.getSousTotal();
		return total;
	}
	
	public void denombrer(int qte)
	{
		if(this.lgAchats.size()!=0)
		{
			//recuperer la derniere ligne de vente
			DTOLigneAchat lgAchat = this.getLastLigneAchat();
			
			//recuperer le prix du produit
		    double prix = lgAchat.getProduit().getPrix();
		    
		    //mise a jour de la quantité et sous total
		    lgAchat.setSousTotal(prix*qte);
		    lgAchat.setQuantite(qte);
		}
	}
	
	
	public boolean finirVente()
	{
		if(this.termine == true)
			return true;
		//finir vente
		this.setTermine(true);
		//total = somme ligne achat
		this.setTotal(this.totalLgAchat());
		
		return true;
	}
	
	public void payerSomme(double somme,JTextField reste)
	{
		this.paiement.setVente(this);
		this.paiement.setTotal(this.getTotal());
		new VenteService().update(this);
		
		//afficher reste
		reste.setText(Double.toString(somme-this.getTotal()));
	}
	
	
}
