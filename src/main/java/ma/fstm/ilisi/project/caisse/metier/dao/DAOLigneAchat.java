package ma.fstm.ilisi.project.caisse.metier.dao;

import java.util.Collection;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ma.fstm.ilisi.project.caisse.metier.bo.LigneAchat;

public class DAOLigneAchat implements IDAOLigneAchat{

	@Override
	public boolean create(LigneAchat lgA) {
		Transaction t = null;
		try
		{
			Session session = HibernateUtil.getSessionFactory().openSession();
			t = session.beginTransaction();
			session.save(lgA);
			t.commit();
			session.close();
			return true;
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
			return false;
		}
	}

	@Override
	public List<LigneAchat> retreive() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(LigneAchat lgA) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(LigneAchat lgA) {
		// TODO Auto-generated method stub
		return false;
	}

}
