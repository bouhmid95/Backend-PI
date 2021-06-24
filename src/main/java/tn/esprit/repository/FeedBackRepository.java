package tn.esprit.repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.entities.Feedback;


public interface FeedBackRepository extends CrudRepository<Feedback, Integer> {

}
