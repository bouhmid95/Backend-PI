package tn.esprit.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tn.esprit.entities.Order;
import tn.esprit.entities.Publication;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

public interface PublicationRepository extends CrudRepository<Publication, Integer>{

	@Query("SELECT count(*) FROM Publication")
    public int countpublications();
	
	
	@Query("FROM Publication p where p.user.id = :id")
	public List<Publication> findPublicationByUserId(@Param("id") Integer id);
}
