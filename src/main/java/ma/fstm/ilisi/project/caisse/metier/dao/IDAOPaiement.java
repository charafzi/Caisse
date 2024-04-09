package ma.fstm.ilisi.project.caisse.metier.dao;


import ma.fstm.ilisi.project.caisse.metier.bo.Paiement;

public interface IDAOPaiement {
	
	public boolean create(Paiement P);
	public int retreive();
	public boolean update(Paiement P);
	public abstract boolean delete(Paiement P);

}
