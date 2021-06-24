package tn.esprit.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.entities.Order;
import tn.esprit.entities.User;
import tn.esprit.services.OrderServiceImpl;

@RestController
public class RestControllerOrder {
	
	private static final Logger logger = Logger.getLogger(RestControllerOrder.class);

	@Autowired
	private OrderServiceImpl orderService;
	
	@PostMapping("/addOrder")
	@ResponseBody
	public Order addOrder(@RequestBody Order order) {
		this.orderService.addOrder(order);
		return order ;
	}
	
	@PutMapping("/updateOrder")
	@ResponseBody
	public Order updateOrder(@RequestBody Order order) {
		this.orderService.updateOrder(order);
		return order;
	}
	
	@DeleteMapping(value = "/deleteOrder/{idOrder}")
	public String deleteOrder(@PathVariable("idOrder") int idOrder) {
		this.orderService.deleteOrder(idOrder);
		return "Order N° " + idOrder + " deleted" ;
	}
	
	@GetMapping("/ListOrder")
	public List<Order> findAllOrder() {
		return this.orderService.findAllOrder();
	}

}
