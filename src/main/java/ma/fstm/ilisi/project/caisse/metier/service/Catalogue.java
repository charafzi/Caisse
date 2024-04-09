package ma.fstm.ilisi.project.caisse.metier.service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import ma.fstm.ilisi.project.caisse.dto.DTOProduit;

public class Catalogue {
	private HashSet<DTOProduit> produits;
	
	public Catalogue()
	{
		produits = new ProduitService().retrieve();
	}
	
	public DTOProduit chercherProduit(int code)
	{
		for(DTOProduit p:produits)
			if(p.getCode() == code)
				return p;
		return null;
	}
	
}
