package ma.fstm.ilisi.project.caisse.metier.service;

import java.util.Set;

import ma.fstm.ilisi.project.caisse.dto.DTOProduit;

public interface ProduitServiceInterface {
	Set<DTOProduit> retrieve();
}
