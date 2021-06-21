package tn.esprit.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.entities.Order;
import tn.esprit.repository.OrderRepository;

@Service
public class OrderServiceImpl implements IOrderService {
	
	@Autowired
	private OrderRepository orderRepository ;

	@Override
	public int addOrder(Order order) {
		this.orderRepository.save(order);
		return order.getId();
	}

	@Override
	public Order deleteOrder(int idOrder) {
		Order order = this.orderRepository.findById(idOrder).orElse(null);
		this.orderRepository.delete(order);
		return order;
	}

	@Override
	public int updateOrder(Order order) {
		this.orderRepository.save(order);
		return order.getId();
	}

	@Override
	public Order findOrder(int idOrder) {
		return this.orderRepository.findById(idOrder).orElse(null) ;
	}

	@Override
	public List<Order> findAllOrder() {
		return (ArrayList<Order>) this.orderRepository.findAll();
	}

}
