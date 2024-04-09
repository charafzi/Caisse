package ma.fstm.ilisi.project.caisse.controleur;


import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import ma.fstm.ilisi.project.caisse.dto.DTOLigneAchat;
import ma.fstm.ilisi.project.caisse.dto.DTOPaiementEspece;
import ma.fstm.ilisi.project.caisse.dto.DTOProduit;
import ma.fstm.ilisi.project.caisse.dto.DTOVente;
import ma.fstm.ilisi.project.caisse.metier.bo.Caissier;
import ma.fstm.ilisi.project.caisse.metier.service.Catalogue;
import ma.fstm.ilisi.project.caisse.metier.service.IncorrectLoginPwd;
import ma.fstm.ilisi.project.caisse.metier.service.ServiceAuth;
import ma.fstm.ilisi.project.caisse.metier.service.VenteService;
import ma.fstm.ilisi.project.caisse.presentation.Formulaire_Auth;
import ma.fstm.ilisi.project.caisse.presentation.Gestion_Vente;
import ma.fstm.ilisi.project.caisse.presentation.Paiement_Espece;

public class Caisse {
	private static Caisse instance;
	private Caissier caissier;
	private DTOVente vente;
	private Gestion_Vente afficheur;
	private Catalogue cat;
	private int solde;
	
	private Caisse()
	{
		this.cat = new Catalogue();
	}
	
	public static Caisse getInstance()
	{
		if(instance==null)
		{
			instance = new Caisse();
		}
		return instance;
	}

	public int getSolde() {
		return solde;
	}

	public void setSolde(int solde) {
		this.solde = solde;
	}
	
	
	
	public DTOVente getVente() {
		return vente;
	}

	public void setVente(DTOVente vente) {
		this.vente = vente;
	}

	public void initialiser() 
    {
        this.setSolde(1000);
        new Formulaire_Auth().setVisible(true);
    }
	
	public void check(JFrame auth,String s1, String s2)
	{
	    String message=new ServiceAuth().check_auth(s1, s2);
	     if (message.equals("success"))
	     {
	    	 JOptionPane.showMessageDialog(null, "Vous etes bien authentifié", "Authentification", 1);
	    	 //fermer la fenetre d'authetification
	    	 auth.dispose();
	    	 
	  
	    	 this.cat = new Catalogue();
	    	 this.afficheur = new Gestion_Vente();
	    	 this.afficheur.lblNom.setText(this.caissier.getNom());
	    	 this.afficheur.lblPrenom.setText(this.caissier.getPrenom());
	    	 this.afficheur.lblSoldeVal.setText(Integer.toString(this.solde));
	    	 this.afficheur.setVisible(true);
	     }
	     
	     else 
	     {
	         if(message.equals("failure"))
	         try 
	         {
	        	 throw new IncorrectLoginPwd();
	         
	         } 
	         catch (IncorrectLoginPwd ex) 
	         {
	           JOptionPane.showMessageDialog(null, "Echec, Vous ne pouvez pas être connecté à la caisse", "Authentification", 0);
	           System.exit(0);
	         }
	         else
	         {
	            JOptionPane.showMessageDialog(null, "Attention ! il vous reste uniquement "+ (3-Integer.valueOf(message))+" tentatives", "Authentification", 0);
	         }
	         
	             
	     }
	  }
	
	public void nouvelleAchat()
	{
		//creation vente 
		LocalDate date = LocalDate.now();
		this.vente = new DTOVente(date);
		
		//masquer l'acceuil
		this.afficheur.setVisible(false);

		//afficher le formulaire de vente
		this.afficheur.form_vente.setVisible(true);
	}
	

	
	public void enregisterArticle(String code)
	{
		try 
		{
		    int codeProduit = Integer.valueOf(code);
		   
		    
		    ///chercher article
		    DTOProduit p =  this.cat.chercherProduit(codeProduit);
		    
		    if (p != null)
		     {
		    	this.vente.ajouterArticle(p);
		    	//affichage des données sur l'interface
		    	//this.afficheur.form_vente.textField_PrixU.setText(Double.toString(p.getPrix()));
		    	//this.afficheur.form_vente.textField_qteAff.setText("1");
		    	//this.afficheur.form_vente.textArea.setText(p.getDesignation());
		    	//this.afficheur.form_vente.textField_SousTotal.setText(Double.toString(p.getPrix()));
		    	this.afficheur.form_vente.textField_Total.setText(Double.toString(this.vente.totalLgAchat()));
		    	
		    	//apporter les lignes d'achat pour les afficher
		    	String[][] data = new String[this.vente.getLgAchats().size()][5];
		    	
		    	for(int i=0; i<this.vente.getLgAchats().size(); i++)
		    	{
		    		DTOLigneAchat lga = this.vente.getLgAchats().get(i);
		    		data[i][0] = Integer.toString(lga.getProduit().getCode());
		    		data[i][1] = lga.getProduit().getDesignation();
		    		data[i][2] = Double.toString(lga.getProduit().getPrix());
		    	    data[i][3] = Double.toString(lga.getQuantite());   
		    	    data[i][4] = Double.toString(lga.getSousTotal());   
		    	}
		    	
		    	DefaultTableModel model = (DefaultTableModel) this.afficheur.form_vente.table.getModel();
		    	int columnCount = model.getColumnCount();

		    	// Array pour stocker les noms de colonnes
		    	String[] columnNames = new String[columnCount];

		    	// Remplir le tableau avec les noms de colonnes
		    	for (int i = 0; i < columnCount; i++) {
		    	    columnNames[i] = model.getColumnName(i);
		    	}
		    	
		        model.setDataVector(data, columnNames);
		    	
		     }
		     
		     else 
		     { 
		    	 JOptionPane.showMessageDialog(null, "Produit de code "+code+" introuvable !", "Message", 0);  
		     }
		    
		    
		} 
		catch (NumberFormatException e) 
		{
			JOptionPane.showMessageDialog(null, "Veuillez insérer un nombre !", "Erreur", 0);  
		}
		
	}
	
	public void denombrer(int qte)
	{
		///denombrer vente
		this.vente.denombrer(qte);
	    //Afficher les niuvelles valeurs 
    	//this.afficheur.form_vente.textField_qteAff.setText(Integer.toString(qte));
    	//this.afficheur.form_vente.textField_SousTotal.setText(Double.toString(this.vente.getLastLigneAchat().getSousTotal()));  
    	this.afficheur.form_vente.textField_Total.setText(Double.toString(this.vente.totalLgAchat()));
    	
    	//apporter les lignes d'achats
    	String[][] data = new String[this.vente.getLgAchats().size()][5];
    	
    	for(int i=0; i<this.vente.getLgAchats().size(); i++)
    	{
    		DTOLigneAchat lga = this.vente.getLgAchats().get(i);
    		data[i][0] = Integer.toString(lga.getProduit().getCode());
    		data[i][1] = lga.getProduit().getDesignation();
    		data[i][2] = Double.toString(lga.getProduit().getPrix());
    	    data[i][3] = Double.toString(lga.getQuantite());   
    	    data[i][4] = Double.toString(lga.getSousTotal());   
    	}
    	
    	
    	DefaultTableModel model = (DefaultTableModel) this.afficheur.form_vente.table.getModel();
    	int columnCount = model.getColumnCount();

    	// Array pour stocker les noms de colonnes
    	String[] columnNames = new String[columnCount];

    	// Remplir le tableau avec les noms de colonnes
    	for (int i = 0; i < columnCount; i++) {
    	    columnNames[i] = model.getColumnName(i);
    	}
    	
        model.setDataVector(data, columnNames);
	}
	
	public void FinirVente()
	{
		if(this.vente.getLgAchats().size()!=0)
		{
			if(this.vente.finirVente())
			{
				//payer vente
				String[] options = {"Par espèces", "Par carte"};
		   
		        int choice = JOptionPane.showOptionDialog(null,
		                "Choisir le mode de paiement :", "Paiement",
		                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
		                null, options, options[0]);
		        
		        if (choice == 0) 
		        {
		        	this.afficheur.form_vente.panel_paie_esp = new Paiement_Espece(this);
		        	this.afficheur.form_vente.panel_paie_esp.setVisible(true);
		        	DTOPaiementEspece p = new DTOPaiementEspece();
		        	p.setVente(vente);
		        	p.setTotal(vente.getTotal());
		        	this.vente.setPaiement(p);
		        	 
		        } 
		        else 
		        {
		            
		        } 
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Erreur d'enregistrement veuillez ressayer !", "Erreur", 0); 
			}
		}
	}
	
	public void payerSomme(Double somme)
	{
		//paiement par espece
		
		if(somme<this.vente.getTotal())
		{
			JOptionPane.showMessageDialog(null, "Montant saise est insufisant !", "Erreur", 0);  
		}
		else
		{
			//******* Transaction
    		new VenteService().save(this.vente);   
			//payer et afficher le reste
			this.vente.payerSomme(somme,this.afficheur.form_vente.panel_paie_esp.textField_1);
			JOptionPane.showMessageDialog(null, "Paiement fait avec succées !", "Information", 1);
			
			//afgicher l'acceuil
			this.afficheur.form_vente.panel_paie_esp.dispose();
			this.afficheur.form_vente.setVisible(false);
			this.afficheur.setVisible(true);
			
			//ajout su total au solde de la caisse
		    this.solde+=this.vente.getTotal();
		    this.afficheur.lblSoldeVal.setText(Double.toString(solde));
		}
	}

	public void setCaissier(Caissier caissier) {
		this.caissier = caissier;
	}
	
	
	public static void main(String[] args) {
		ArrayList<DTOVente> ventes = new VenteService().retrieve();
		
		for(DTOVente v:ventes)
		{
			System.out.println("Vente : "+v.getDate());
			for(DTOLigneAchat lga:v.getLgAchats())
			{
				System.out.println("LigneAchat : "+lga.getSousTotal()+","+lga.getProduit().getDesignation());
			}

			System.out.println("--------------------------------------");
		}
		}
	
	
}



