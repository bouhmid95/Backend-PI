package tn.esprit.services;

import java.util.List;

import tn.esprit.entities.DeliveryMan;
import tn.esprit.entities.Order;

public interface IDeliveryManService {

	public int addDeliveryMan(DeliveryMan DeliveryMan);

	public int deleteDeliveryMan(int idDeliveryMan);

	public int updateDeliveryMan(DeliveryMan DeliveryMan);

	public DeliveryMan findDeliveryMan(int idDeliveryMan);
	
	public String affectOrdersToDeliveryMan(List<Order> orders,int idDeliveryMan);

}
