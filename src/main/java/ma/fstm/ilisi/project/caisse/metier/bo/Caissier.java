package ma.fstm.ilisi.project.caisse.metier.bo;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 *
 * @author achraf
 */
@Entity
public class Caissier implements Serializable{
	@Id
	private int matricule;
	private String nom;
	private String prenom;
	private String login;
	private String password;

	Caissier()
	{
		
	}
	
	
    public Caissier(int matricule, String nom, String prenom) {
		super();
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
	}



   public int getMatricule(){
   return matricule;
   
   }
   public void setMatricule(int matricule){
   this.matricule=matricule;
   }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
       
       
}
