package tn.esprit.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.entities.Stock;
import tn.esprit.services.IStockService;

@RestController
public class RestStockController {
	private static final Logger logger = Logger.getLogger(RestControlUser.class);
	
	@Autowired
	IStockService StockServices;
	
	@PostMapping("/addStock")
	@ResponseBody
	public Stock addStock(@RequestBody Stock Stock) {
		logger.info("---- ajouter Stock Méthode ---");
		StockServices.addStock(Stock);
		return Stock;
	}

	@PostMapping("/updateStock")
	@ResponseBody
	public Stock updateUser(@RequestBody Stock Stock) {
		logger.info("---- update Stock Méthode ---");
		StockServices.updateStock(Stock);
		return Stock;
	}

	@DeleteMapping(value = "/deleteStock/{idStock}")
	public Stock deleteStock(@PathVariable("idStock") int idStock) {
		logger.info("---- delete Stock Méthode ---");
		return StockServices.deleteStock(idStock);
	}

	// http://localhost:8082/SpringMVC/servlet/findUser/1

	@GetMapping(value = "/findStock/{idStock}")
	public Stock findStock(@PathVariable("idStock") int idStock) {
		logger.info("---- find Stock Méthode ---");
		
		logger.debug("This is a debug message");
		logger.info("This is an info message");
		logger.warn("This is a warn message");
		logger.error("This is an error message");
		return StockServices.findStock(idStock);
	}

	@GetMapping(value = "/findAllStock")
	public List<Stock> findAllStock() {
		return StockServices.findAllStock();
	}

}
