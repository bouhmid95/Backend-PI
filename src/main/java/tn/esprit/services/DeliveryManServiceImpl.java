package tn.esprit.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.entities.AffectationDto;
import tn.esprit.entities.DeliveryMan;
import tn.esprit.entities.DeliveryManStat;
import tn.esprit.entities.Order;
import tn.esprit.entities.PropositionDto;
import tn.esprit.entities.User;
import tn.esprit.repository.DeliveryManRepository;
import tn.esprit.repository.DeliveryManStatRepository;
import tn.esprit.repository.DeliveryRepositoryCriteria;
import tn.esprit.repository.OrderRepository;
import tn.esprit.repository.UserRepository;

@Service
public class DeliveryManServiceImpl implements IDeliveryManService,DeliveryRepositoryCriteria{
	
	@PersistenceContext
    private EntityManager em;
	

	@Autowired
	UserRepository userRepository;
	

	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	DeliveryManStatRepository deliveryManStatRepository;
	
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
		return deliveryManRepository.findById(idDeliveryMan).orElse(null);
	}


	
	@Override
	public String affectOrdersToDeliveryMan(AffectationDto aff) {
		
		  List<Order> o = aff.getOrders();
		  int idDM = aff.getIdDeliveryMan();
		  
		  DeliveryMan d = deliveryManRepository.findById(idDM).get();
		  
		  o.stream().forEach(x->{x.setDeliveryMan(d);
			orderRepository.save(x);
			});
		  
		 
		return "affectation effectué avec succées";
		

	}

	@Override
	public List<DeliveryMan> listDeliveryMan() {
		// TODO Auto-generated method stub
		 return (List<DeliveryMan>) deliveryManRepository.findAll();
	}

	@Override
	public DeliveryMan getDeliveryManByFirstName(String prenom) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		 CriteriaQuery<DeliveryMan> criteriaQuery = cb.createQuery(DeliveryMan.class); 
		 Root<DeliveryMan> root = criteriaQuery.from(DeliveryMan.class);
		 criteriaQuery.select(root);
		 
//		 ParameterExpression<String> p = cb.parameter(String.class);
		 criteriaQuery.select(root).where(cb.like(root.get("firstName"), "%"+prenom+"%"));
		 
		 TypedQuery<DeliveryMan> query = em.createQuery(criteriaQuery);
//		 query.setParameter(p, prenom);
		 try {
			 if(query.getSingleResult()!=null) {
				 return query.getSingleResult();
			 }
		} catch (Exception e) {
			return null;
		}
		 
		 return null;
		 
		
	}

	@Override
	public List<Order> getListOrdersByDeliveryManId(int id) {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		 CriteriaQuery<Order> criteriaQuery = cb.createQuery(Order.class); 
		 Root<Order> root = criteriaQuery.from(Order.class);
		 criteriaQuery.select(root);
		 DeliveryMan dv = findDeliveryMan(id);
//		 ParameterExpression<String> p = cb.parameter(String.class);
		 criteriaQuery.select(root).where(cb.equal(root.get("deliveryMan"), dv));
		 
		 TypedQuery<Order> query = em.createQuery(criteriaQuery);
//		 query.setParameter(p, prenom);
		 try {
			 if(query.getResultList().size()!=0 ) {
				 return query.getResultList();
			 }
		} catch (Exception e) {
			return null;
		}
		 
		 return null;
	}

	@Override
	public String setOrderDelivered_Criteria(int idDeliveryMan,int idOrder) {
		Order myOrder = getOrderByDeliveryManId(idDeliveryMan,idOrder);
		
		myOrder.setStatus("DELIVERED");
	
		
		orderRepository.save(myOrder);
		
		
		return "commande livrée avec succées !";
	}
	
	
	public Order getOrderByDeliveryManId(int idDeliveryMan,int idOrder) {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		 CriteriaQuery<Order> criteriaQuery = cb.createQuery(Order.class); 
		 Root<Order> root = criteriaQuery.from(Order.class);
		 criteriaQuery.select(root);
		 DeliveryMan dv = findDeliveryMan(idDeliveryMan);
//		 ParameterExpression<String> p = cb.parameter(String.class);
		 criteriaQuery.select(root).where(cb.equal(root.get("deliveryMan"), dv));
		 
		 TypedQuery<Order> query = em.createQuery(criteriaQuery);
//		 query.setParameter(p, prenom);
		 try {
			 if(query.getResultList().size()!=0 ) {
				 List<Order> list = query.getResultList();
				 return list.stream().filter(x->x.getId()==idOrder).findFirst().get();
				
			 }
		} catch (Exception e) {
			return null;
		}
		 
		 return null;
		
	}

	@Override
	public List<DeliveryManStat> getAllDeliveryManStatus() {
		// TODO Auto-generated method stub
		return (List<DeliveryManStat>) deliveryManStatRepository.findAll();
	}

	@Override
	public DeliveryManStat getDeliveryManStatById(int id) {
	
		return deliveryManStatRepository.findById(id).get();
	}

	@Override
	public PropositionDto optimisationAlgo(int codePostalOrder) {
		PropositionDto proposition = new PropositionDto();
		List<DeliveryMan> listDeliveryMan = getListDeliveryManByCodePostal(codePostalOrder);
		if(listDeliveryMan!=null) {
			
			proposition.setCodePostal("livraison de la code Postal N° "+codePostalOrder+" pourrait être livré par " + 
					" :  ");
			
            proposition.setListDeliveryMan(listDeliveryMan);
            
            return proposition;
			
			
		}else {
			proposition.setCodePostal("aucun livreur pourrait livrer cette livraison");
			  proposition.setListDeliveryMan(null);
			  return proposition;
		}
		
		
	}
	
	public List<DeliveryMan> getListDeliveryManByCodePostal(int codePostalOrder) {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		 CriteriaQuery<DeliveryMan> criteriaQuery = cb.createQuery(DeliveryMan.class); 
		 Root<DeliveryMan> root = criteriaQuery.from(DeliveryMan.class);
		 criteriaQuery.select(root);

		 criteriaQuery.select(root).where(cb.equal(root.get("codePostal"), codePostalOrder));
		 
		 TypedQuery<DeliveryMan> query = em.createQuery(criteriaQuery);

		 try {
			 if(query.getResultList().size()!=0 ) {
				 return query.getResultList();
			 }
		} catch (Exception e) {
			return null;
		}
		 
		 return null;
	}






}
