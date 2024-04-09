package ma.fstm.ilisi.project.caisse.metier.service;

import ma.fstm.ilisi.project.caisse.dto.DTOLigneAchat;
import ma.fstm.ilisi.project.caisse.metier.bo.LigneAchat;
import ma.fstm.ilisi.project.caisse.metier.dao.DAOLigneAchat;

public class LigneAchatService implements LigneAchatServiceInterface {

	@Override
	public void save(DTOLigneAchat lga) {
		new DAOLigneAchat().create(toLigneAchat(lga));
	}
	
	public DTOLigneAchat fromLigneAchat(LigneAchat lga)
	{
		return new DTOLigneAchat(new ProduitService().fromProduit(lga.getProduit()),lga.getQuantite(),lga.getSousTotal());
	}
	
	public LigneAchat toLigneAchat(DTOLigneAchat lga)
	{
		return new LigneAchat(new ProduitService().toProduit(lga.getProduit()),lga.getQuantite(),lga.getSousTotal());
	}

}
