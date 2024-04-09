package ma.fstm.ilisi.project.caisse.metier.service;

import java.util.List;

import ma.fstm.ilisi.project.caisse.dto.DTOVente;

public interface VenteServiceInterface {
	public boolean save(DTOVente v);
	public boolean update(DTOVente v);
	public List<DTOVente> retrieve();

}
