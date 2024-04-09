package ma.fstm.ilisi.project.caisse.metier.dao;

import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.Session;
import ma.fstm.ilisi.project.caisse.metier.bo.Produit;
import oracle.jdbc.oracore.Util;

public class DAOProduit implements IDAOProduit{

	@Override
	public boolean create(Produit P) {
		Transaction t = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			t = session.beginTransaction();
			session.save(P);
			t.commit();
			session.close();
			return true;
		}
		catch(Exception e)
		{
			t.rollback();
			System.err.println(e.toString());
			return false;
			
		}
	}

	@Override
	public List<Produit> retreive() {
		try
		{
			Session session = HibernateUtil.getSessionFactory().openSession();
			
			return session.createQuery("FROM Produit", Produit.class).list();
	
		}
		catch(Exception e)
		{
			System.err.println(e.toString());
			return null;
			
		}
	}

	@Override
	public boolean update(Produit P) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Produit P) {
		Transaction t = null;
		try
		{
			Session session= HibernateUtil.getSessionFactory().openSession();
			t = session.beginTransaction();
			session.delete(P);
			t.commit();
			session.close();
			return true;
			
		}
		catch(Exception e)
		{
			t.rollback();
			System.err.println(e.toString());
			return false;
		}
	}
	
	@Override
	public Produit getProduitById(int id) {
		try
		{
			Session session = HibernateUtil.getSessionFactory().openSession();
			return session.get(Produit.class, id);
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
			return null;
		}
	}
	
	
	public static void main(String[] args) {
		List<Produit> produits = new DAOProduit().retreive();
		
		for(Produit p:produits )
		{
			System.out.println(p.getDesignation());
		}
		System.out.println("done");
	}

	

}
