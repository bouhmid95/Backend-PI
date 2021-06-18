package tn.esprit.repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
