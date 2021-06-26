package tn.esprit.repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.entities.Comment;

public interface CommentRepository extends CrudRepository<Comment, Integer>{

}
