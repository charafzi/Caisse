package ma.fstm.ilisi.project.caisse.metier.dao;
import java.util.Collection;

import ma.fstm.ilisi.project.caisse.metier.bo.Vente;

public interface IDAOVente 
{
	public boolean create(Vente V);
	public Collection<Vente> retreive();
	public boolean update(Vente V);
	public abstract boolean delete(Vente V);

}
