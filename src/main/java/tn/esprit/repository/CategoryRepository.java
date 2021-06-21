package tn.esprit.repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.entities.Category;

public interface CategoryRepository extends CrudRepository<Category, Integer> {

}
