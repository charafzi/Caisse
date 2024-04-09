package ma.fstm.ilisi.project.caisse.metier.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import ma.fstm.ilisi.project.caisse.dto.DTOLigneAchat;
import ma.fstm.ilisi.project.caisse.dto.DTOVente;
import ma.fstm.ilisi.project.caisse.metier.bo.LigneAchat;
import ma.fstm.ilisi.project.caisse.metier.bo.Paiement;
import ma.fstm.ilisi.project.caisse.metier.bo.Produit;
import ma.fstm.ilisi.project.caisse.metier.bo.Vente;
import ma.fstm.ilisi.project.caisse.metier.dao.DAOVente;
import ma.fstm.ilisi.project.caisse.metier.dao.HibernateUtil;

public class VenteService implements VenteServiceInterface{

	@Override
	public boolean save(DTOVente v) {
		return (new DAOVente().create(toVente(v)));
		
	}
	
	@Override
	public boolean update(DTOVente v) {
		return (new DAOVente().update(toVente(v)));	}

	public DTOVente fromVente(Vente v)
	{
		DTOVente vente = new DTOVente();
		vente.setDate(v.getDate());
		vente.setTermine(v.isTermine());
		vente.setTotal(v.getTotal());	
		
		LigneAchatService las = new LigneAchatService();
		List<DTOLigneAchat> lgachats = new ArrayList<>();
		for(LigneAchat lga:v.getLgAchats())
		{
			DTOLigneAchat ligne = las.fromLigneAchat(lga);
			ligne.setVente(vente);
			lgachats.add(ligne);
		}
		vente.setLgAchats(lgachats);
		return vente;
	}
	

	public Vente toVente(DTOVente v)
	{
		Vente vente = new Vente();
		vente.setDate(v.getDate());
		vente.setTermine(v.isTermine());
		vente.setTotal(v.getTotal());
		Paiement p = new PaiementService().toPaiement(v.getPaiement());
		p.setVente(vente);
		vente.setPaiement(p);
		LigneAchatService las = new LigneAchatService();
		List<LigneAchat> lgachats = new ArrayList<>();
		
		for(DTOLigneAchat lga:v.getLgAchats())
		{
			LigneAchat ligne = las.toLigneAchat(lga);
			ligne.setVente(vente);
			lgachats.add(ligne);
		}
		
		vente.setLgAchats(lgachats);
		/*for(LigneAchat l:vente.getLgAchats())
		{
			System.out.println("*********toVente "+l.getVente()+"*****"+l.getProduit().getDesignation());
		}*/
		return vente;
	}
	@Override
	public ArrayList<DTOVente> retrieve() {
		ArrayList<DTOVente> ventes = new ArrayList<>();
		
		List<Vente> daoventes = new DAOVente().retreive();
		for(Vente v:daoventes)
		{
			ventes.add(fromVente(v));
		}
		return ventes;
	}

	

	
}
