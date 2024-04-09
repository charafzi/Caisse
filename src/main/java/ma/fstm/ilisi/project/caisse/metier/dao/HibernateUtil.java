package ma.fstm.ilisi.project.caisse.metier.dao;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
	private static SessionFactory sessionFactory;
	
	static {
		try 
		{
			Configuration config = new Configuration();
			config.configure("ma/fstm/ilisi/project/caisse/metier/dao/hibernate.cfg.xml");
			sessionFactory = config.buildSessionFactory();
		}
		catch(HibernateException e)
		{
			System.err.println(e.getMessage());
			sessionFactory=null;
		}
		
	}
	public static SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}
	public static void main(String[] b)
	{
		System.out.println(HibernateUtil.getSessionFactory());
	}

}

