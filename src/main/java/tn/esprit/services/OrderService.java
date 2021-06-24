package tn.esprit.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.entities.Order;
import tn.esprit.repository.OrderRepository;

@Service
public class OrderService implements IOrderService {
	
	@Autowired
	OrderRepository orderRepo;

	@Override
	public int addOrder(Order order) {
		orderRepo.save(order);
		return order.getId();
	}

	@Override
	public Order deleteOrder(int idOrder) {
		Order order= orderRepo.findById(idOrder).orElse(null);
		orderRepo.delete(order);
		return order;
	}

	@Override
	public int updateOrder(Order order) {
		
		Order orderOld = orderRepo.findById(order.getId()).orElse(null);
		orderOld.setAdresse(order.getAdresse());
		orderOld.setCodePostal(order.getAdresse());
		orderOld.setDeliveryMan(order.getDeliveryMan());
		orderOld.setOrderDate(order.getOrderDate());
		orderOld.setReference(order.getReference());
		orderOld.setStatus(order.getStatus());
		orderOld.setTypePaiement(order.getTypePaiement());
		orderOld.setUser(order.getUser());
		
		return 0;
	}

	@Override
	public Order findOrder(int idOrder) {
		// TODO Auto-generated method stub
		return orderRepo.findById(idOrder).orElse(null) ;
	}

	@Override
	public List<Order> findAllOrder() {
		// TODO Auto-generated method stub
		return null;
	}

}
