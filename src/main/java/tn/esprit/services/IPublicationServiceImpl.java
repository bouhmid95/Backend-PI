package tn.esprit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.entities.Publication;
import tn.esprit.entities.User;
import tn.esprit.repository.PublicationRepository;
import tn.esprit.repository.UserRepository;


@Service
public class IPublicationServiceImpl implements IPublicationService {
	
	
	@Autowired
	PublicationRepository publicationRepository;


	@Override
	public int addPublication(Publication publication) {
		publicationRepository.save(publication);
		return publication.getId();
	}

	@Override
	public Publication deletePublication(int idPublication) {
		Publication publication = publicationRepository.findById(idPublication).orElse(null);
		publicationRepository.delete(publication);
		return publication;
	}

	@Override
	public int updatePublication(Publication publication) {
		Publication oldpublication = publicationRepository.findById(publication.getId()).orElse(null);
		oldpublication.setContent(publication.getContent());
		oldpublication.setNbDisLike(publication.getNbDisLike());
		oldpublication.setNbLike(publication.getNbLike());
		oldpublication.setPublicationDate(publication.getPublicationDate());
		oldpublication.setUser(publication.getUser());
		publicationRepository.save(oldpublication);
		return 0;
	}

	@Override
	public Publication findPublication(int idPublication) {
	Publication publication = publicationRepository.findById(idPublication).orElse(null);
	return publication;
	}
}
