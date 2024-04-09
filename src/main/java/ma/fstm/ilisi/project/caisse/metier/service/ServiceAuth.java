package ma.fstm.ilisi.project.caisse.metier.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import ma.fstm.ilisi.project.caisse.controleur.Caisse;
import ma.fstm.ilisi.project.caisse.metier.bo.Caissier;
import ma.fstm.ilisi.project.caisse.metier.dao.HibernateUtil;

public class ServiceAuth {
	public static int cpt;
	
	public String check_auth(String s1,String s2)
	  {
		
		try
		{
			System.out.println(s1+" "+s2);
			Session session = HibernateUtil.getSessionFactory().openSession();
			Query<Caissier> query = session.createQuery("FROM Caissier WHERE login = :login AND password = :password", Caissier.class);
	        query.setParameter("login", s1);
	        query.setParameter("password", s2);
	        List<Caissier> results = query.list();
	        
	        if(! results.isEmpty())
	        {
	        	Caisse.getInstance().setCaissier(results.getFirst());
	        	return "success";
	        }
			else
			{
				if (cpt==3) 
		            return "failure";
		       
		           
			    else
		        {
		    	cpt++;
		        return String.valueOf(cpt);
		        }
			}	
			
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
			return "failure";			
		}
	  }

}
