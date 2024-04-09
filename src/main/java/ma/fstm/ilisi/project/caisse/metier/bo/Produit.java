package ma.fstm.ilisi.project.caisse.metier.bo;

import java.io.Serializable;

import jakarta.persistence.*;

@Entity
public class Produit implements Serializable{
	@Id
	private int code;
	private String designation;
	private double prix;
	
	Produit()
	{
		
	}
	
	public Produit(int code, String designation, double prix) 
	{
		this.code = code;
		this.designation = designation;
		this.prix = prix;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	@Override
	public String toString() {
		
		return "Produit :"+code+" ,designation :"+designation+", prix :"+prix;
	}
	
	
	
	

}
