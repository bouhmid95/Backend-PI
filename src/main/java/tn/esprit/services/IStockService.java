package tn.esprit.services;

import java.util.List;

import tn.esprit.entities.Stock;

public interface IStockService {
	
	public int addStock(Stock stock);

	public Stock deleteStock(int idStock);

	public int updateStock(Stock stock);

	public Stock findStock(int idStock);
	
	public List<Stock> findAllStock();

}
