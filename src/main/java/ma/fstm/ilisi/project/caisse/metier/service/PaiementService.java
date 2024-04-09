package ma.fstm.ilisi.project.caisse.metier.service;

import ma.fstm.ilisi.project.caisse.dto.DTOPaiement;
import ma.fstm.ilisi.project.caisse.metier.bo.Paiement;
import ma.fstm.ilisi.project.caisse.metier.dao.DAOPaiment;

public class PaiementService implements PaiementServiceInterface{
	
	@Override
	public boolean save(DTOPaiement p) {
		return (new DAOPaiment().create(toPaiement(p)));
	}
	
	DTOPaiement fromPaiement(Paiement p)
	{
		return null;
		
	}
	
	Paiement toPaiement(DTOPaiement p)
	{
		Paiement paiement = new Paiement();
		paiement.setTotal(p.getTotal());
		return paiement;
		
	}

	

}
