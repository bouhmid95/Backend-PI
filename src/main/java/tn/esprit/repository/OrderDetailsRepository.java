package tn.esprit.repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.entities.OrderDetails;

public interface OrderDetailsRepository extends CrudRepository<OrderDetails, Integer> {

}
