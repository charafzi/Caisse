package ma.fstm.ilisi.project.caisse.metier.dao;

import java.util.Collection;

import ma.fstm.ilisi.project.caisse.metier.bo.Produit;

public interface IDAOProduit {
	public boolean create(Produit P);
	public Collection<Produit> retreive();
	public boolean update(Produit P);
	public boolean delete(Produit P);
	public Produit getProduitById(int id);

}
