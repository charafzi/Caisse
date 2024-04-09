package ma.fstm.ilisi.project.caisse.metier.service;

public class IncorrectLoginPwd extends Exception{
	
	public String toString()
	{
		return "Vous avez depassé le nombre de tentative pour s'authentifier !";
	}

}
