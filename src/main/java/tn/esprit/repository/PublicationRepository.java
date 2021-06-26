package tn.esprit.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tn.esprit.entities.Publication;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

public interface PublicationRepository extends CrudRepository<Publication, Integer>{

	@Query("SELECT count(*) FROM Publication")
    public int countpublications();
	
	
	@Query("select p from Publication p inner join User u on u.id=p.user.id where u.id=:id")
	public List<Publication> findPublicationByUserId(@Param("id") int id);
}


	