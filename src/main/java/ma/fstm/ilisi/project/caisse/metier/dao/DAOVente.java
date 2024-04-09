package ma.fstm.ilisi.project.caisse.metier.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ma.fstm.ilisi.project.caisse.metier.bo.LigneAchat;
import ma.fstm.ilisi.project.caisse.metier.bo.Vente;

public class DAOVente implements IDAOVente {

	@Override
	public boolean create(Vente V) {
		Transaction t = null;
		try
		{
			
			Session session = HibernateUtil.getSessionFactory().openSession();
			t = session.beginTransaction();
			session.save(V);
			
			for(LigneAchat lga:V.getLgAchats())
			{
				session.save(lga);
			}
			session.saveOrUpdate(V.getPaiement());
			t.commit();
			session.close();
			System.out.println("Achat bien enregistré !");
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
	public List<Vente> retreive() {
		try
		{
			Session session = HibernateUtil.getSessionFactory().openSession();
			return session.createQuery("FROM Vente", Vente.class).list();
			
		}
		catch(Exception e)
		{
			System.err.println(e.toString());
			return null;
		}
	}

	@Override
	public boolean update(Vente V) {
		Transaction t = null;
		System.out.println(V.getTotal());
		System.out.println(V.getPaiement().getTotal());
		try
		{
			
			Session session = HibernateUtil.getSessionFactory().openSession();
			t = session.beginTransaction();
			
			
			
	       // session.update(V);
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
	public boolean delete(Vente V) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public static void main(String args[])
	{
		ArrayList<Vente> ventes = new ArrayList<>(new DAOVente().retreive());
		for(Vente v:ventes)
		{
			System.out.println(v.getIdVente());
			
			for(LigneAchat lga:v.getLgAchats())
			{
				System.out.println("id :"+lga.getId());
			}
		}
		
		
	}
}
