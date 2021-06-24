package tn.esprit.services;

import tn.esprit.entities.Publication;


public interface IPublicationService {

	public int addPublication(Publication publication);

	public Publication deletePublication(int idPublication);

	public int updatePublication(Publication user);

	public Publication findPublication(int idPublication);
	
}
