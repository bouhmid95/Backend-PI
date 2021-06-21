package tn.esprit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.entities.Stock;
import tn.esprit.repository.StockRepository;

@Service
public class StockServiceImpl implements IStockService {

	@Autowired
	StockRepository stockRepository;
	@Override
	public int addStock(Stock stock) {
		stockRepository.save(stock);
		return stock.getId();
	}

	@Override
	public Stock deleteStock(int idStock) {
		Stock stock = stockRepository.findById(idStock).orElse(null);
		stockRepository.delete(stock);
		// TODO Auto-generated method stub
		return stock;
	}

	@Override
	public int updateStock(Stock stock) {
		Stock oldStock = stockRepository.findById(stock.getId()).orElse(null);
		
		oldStock.setProduct(stock.getProduct());
		oldStock.setQte(stock.getQte());
		
		stockRepository.save(oldStock);
		
		return oldStock.getId();
	}

	@Override
	public Stock findStock(int idStock) {
		
		return stockRepository.findById(idStock).orElse(null);
	}

	@Override
	public List<Stock> findAllStock() {
		// TODO Auto-generated method stub
		return (List<Stock>)stockRepository.findAll();
	}
	
	

}
