package tn.esprit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.entities.DeliveryMan;
import tn.esprit.entities.Order;
import tn.esprit.entities.User;
import tn.esprit.repository.DeliveryManRepository;
import tn.esprit.repository.UserRepository;

@Service
public class DeliveryManServiceImpl implements IDeliveryManService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	DeliveryManRepository delivManRepository;
	
	@Autowired
	DeliveryManRepository deliveryManRepository;


	
	@Override
	public int addDeliveryMan(DeliveryMan deliveryMan) {
		deliveryManRepository.save(deliveryMan);
		return deliveryMan.getId();
	}

	@Override
	public int deleteDeliveryMan(int idDeliveryMan) {
		DeliveryMan deliveryMan = deliveryManRepository.findById(idDeliveryMan).orElse(null);
		deliveryManRepository.delete(deliveryMan);
		return idDeliveryMan;
	}

	@Override
	public int updateDeliveryMan(DeliveryMan deliv) {
		DeliveryMan object = deliveryManRepository.findById(deliv.getId()).orElse(null);
		if(object!=null) {
			deliv.setId(object.getId());
			deliveryManRepository.save(deliv);
			return 1;
		}
			
		return 0;
	}

	@Override
	public DeliveryMan findDeliveryMan(int idDeliveryMan) {
		// TODO Auto-generated method stub
		return deliveryManRepository.findById(idDeliveryMan).get();
	}

	@Override
	public String affectOrdersToDeliveryMan(List<Order> orders,int idDeliveryMan) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DeliveryMan> listDeliveryMan() {
		// TODO Auto-generated method stub
		 return (List<DeliveryMan>) deliveryManRepository.findAll();
	}


}
