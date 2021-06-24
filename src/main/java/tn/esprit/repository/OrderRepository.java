package tn.esprit.repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.entities.Order;

public interface OrderRepository extends CrudRepository<Order, Integer>  {

}
