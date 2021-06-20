package tn.esprit.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.entities.DeliveryMan;
import tn.esprit.entities.User;
import tn.esprit.services.IDeliveryManService;

@RequestMapping("dm")
@RestController
public class RestControllerDeliveryMan {
	
	private static final Logger logger = Logger.getLogger(RestControlUser.class);


	@Autowired
	IDeliveryManService iDeliveryManService;
	
	@GetMapping("/")
	public String test() {
		logger.info("----test ---");
	
		return "hello";
	}
	
	@PostMapping("/adddvm")
	@ResponseBody
	public DeliveryMan addDeliveryMan(@RequestBody DeliveryMan deliveryMan) {
		logger.info("---- ajouter deliveryMan Méthode ---");
		iDeliveryManService.addDeliveryMan(deliveryMan);
		return deliveryMan;
	}
	
	@PostMapping("/updatedvm")
	@ResponseBody
	public DeliveryMan updateDeliveryMan(@RequestBody DeliveryMan dvm) {
		logger.info("---- update DeliveryMan Méthode ---");
	   iDeliveryManService.updateDeliveryMan(dvm);
		return dvm;
	}
	
	@DeleteMapping(value = "/deletedvm/{id}")
	public int deletedvm(@PathVariable int id) {
		logger.info("---- delete User Méthode ---");
		return iDeliveryManService.deleteDeliveryMan(id);
	}

	
	
	
	
	

}
