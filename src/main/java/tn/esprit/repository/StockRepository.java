package tn.esprit.repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.entities.Stock;

public interface StockRepository extends CrudRepository<Stock, Integer> {

}
