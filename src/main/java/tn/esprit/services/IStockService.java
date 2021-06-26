package tn.esprit.services;

import java.util.List;

import tn.esprit.entities.OrderDetails;
import tn.esprit.entities.Stock;

public interface IStockService {
	
	public int addStock(Stock stock);

	public Stock deleteStock(int idStock);

	public int updateStock(Stock stock);

	public Stock findStock(int idStock);
	
	public List<Stock> findAllStock();
	
	public boolean decrementFromStock(List<OrderDetails> DetailsOrder);
	
	public List<Stock> checkAlertStock();
	
	public Stock getStockByProduct(int idProduct); 

}
