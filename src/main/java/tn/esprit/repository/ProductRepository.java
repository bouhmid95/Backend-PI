package tn.esprit.repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>  {

}
