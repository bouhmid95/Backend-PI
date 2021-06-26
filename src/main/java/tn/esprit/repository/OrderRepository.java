package tn.esprit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tn.esprit.entities.Order;

public interface OrderRepository extends CrudRepository<Order, Integer>  {
	
	@Query("FROM Order o where o.user.id = :id")
	public List<Order> findOrderByUserId(@Param("id") Integer id);
}
