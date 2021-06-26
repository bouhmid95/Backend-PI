package tn.esprit.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tn.esprit.entities.Stock;

public interface StockRepository extends CrudRepository<Stock, Integer> {
	
	@Query("select c from Stock c join c.product p where p.id=:product")
	public Stock getStockByProduct(@Param("product") int productID);

}
