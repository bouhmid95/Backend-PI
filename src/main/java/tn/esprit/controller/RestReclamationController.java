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

import tn.esprit.entities.Reclamation;
import tn.esprit.services.IReclamationService;

@RestController
public class RestReclamationController {

	private static final Logger logger = Logger.getLogger(RestReclamationController.class);
	
	@Autowired
	IReclamationService reclamationServices;
	

	@PostMapping("/addReclamation")
	@ResponseBody
	public Reclamation addReclamation(@RequestBody Reclamation reclamation) {
		logger.info("---- ajouter Reclamation Méthode ---");
		reclamationServices.addReclamation(reclamation);
		return reclamation;
	}

	@PostMapping("/updateReclamation")
	@ResponseBody
	public Reclamation updateReclamation(@RequestBody Reclamation reclamation) {
		logger.info("---- update Reclamation Méthode ---");
		reclamationServices.updateProduct(reclamation);
		return reclamation;
	}

	@DeleteMapping(value = "/deleteReclamation/{idReclamation}")
	public Reclamation deleteReclamation(@PathVariable("idReclamation") int idReclamation) {
		logger.info("---- delete Reclamation Méthode ---");
		return reclamationServices.deleteReclamation(idReclamation);
	}

	// http://localhost:8082/SpringMVC/servlet/findReclamation/1

	@GetMapping(value = "/findReclamation/{idReclamation}")
	public Reclamation findReclamation(@PathVariable("idReclamation") int idReclamation) {
		logger.info("---- find Reclamation Méthode ---");
		return reclamationServices.findReclamation(idReclamation);
	}

	@GetMapping(value = "/findAllReclamation")
	@ResponseBody
	public List<Reclamation> findAllReclamation() {
		return reclamationServices.findAllReclamation();
	}

}
