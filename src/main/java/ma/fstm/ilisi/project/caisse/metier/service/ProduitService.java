package ma.fstm.ilisi.project.caisse.metier.service;

import java.util.HashSet;
import java.util.List;
import ma.fstm.ilisi.project.caisse.dto.DTOProduit;
import ma.fstm.ilisi.project.caisse.metier.bo.Produit;
import ma.fstm.ilisi.project.caisse.metier.dao.DAOProduit;

public class ProduitService implements ProduitServiceInterface{
	private HashSet<DTOProduit> produits;

	@Override
	public HashSet<DTOProduit> retrieve() 
	{
		produits = new HashSet<>();
		List<Produit> daoproduits = new DAOProduit().retreive();
		for(Produit p:daoproduits)
		{
			produits.add(fromProduit(p));
		}
		return produits;
	}
	
	DTOProduit fromProduit(Produit p)
	{
		return new DTOProduit(p.getCode(),p.getDesignation(),p.getPrix());
		
	}
	
	Produit toProduit(DTOProduit p)
	{
		return new Produit(p.getCode(),p.getDesignation(),p.getPrix());
	}

	

}
