package ma.fstm.ilisi.project.caisse.metier.dao;

import java.util.Collection;

import ma.fstm.ilisi.project.caisse.metier.bo.LigneAchat;

public interface IDAOLigneAchat {
	public boolean create(LigneAchat lgA);
	public Collection<LigneAchat> retreive();
	public boolean update(LigneAchat lgA);
	public boolean delete(LigneAchat lgA);

}
