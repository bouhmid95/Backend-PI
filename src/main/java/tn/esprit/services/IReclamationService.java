package tn.esprit.services;

import java.util.List;

import org.springframework.stereotype.Service;

import tn.esprit.entities.Reclamation;

@Service
public interface IReclamationService {

	
	public int addReclamation(Reclamation Reclamation);

	public Reclamation deleteReclamation(int idReclamation);

	public int updateProduct(Reclamation reclamation);

	public Reclamation findReclamation(int idReclamation);
	
	public List<Reclamation> findAllReclamation();
}
