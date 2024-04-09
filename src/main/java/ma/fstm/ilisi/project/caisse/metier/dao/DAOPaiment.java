package ma.fstm.ilisi.project.caisse.metier.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ma.fstm.ilisi.project.caisse.metier.bo.Paiement;
import ma.fstm.ilisi.project.caisse.metier.bo.Vente;

public class DAOPaiment implements IDAOPaiement {

	@Override
	public boolean create(Paiement P) {
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
	public int retreive() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean update(Paiement P) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Paiement P) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public static void main(String[] aa)
	{
		Vente v = new Vente();
		v.setIdVente(44);
		Paiement p = new Paiement(v, 5162.0);
		
		DAOPaiment d = new DAOPaiment();
		
		d.create(p);
	}

}
