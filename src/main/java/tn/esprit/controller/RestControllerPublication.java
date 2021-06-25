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

import tn.esprit.entities.Comment;
import tn.esprit.entities.Publication;
import tn.esprit.services.IPublicationService;

@RestController
public class RestControllerPublication {
	
	private static final Logger logger = Logger.getLogger(RestControlUser.class);
	
	@Autowired
	IPublicationService iPublicationService;
	
	
	@PostMapping("/addPublication")
	@ResponseBody
	public Publication addPublication(@RequestBody Publication publication) {
		logger.info("---- add publication Method ---");
		iPublicationService.addPublication(publication);
		return publication;
	}
	
	
	@DeleteMapping(value = "/deletePublication/{idPublication}")
	public Publication deleteUser(@PathVariable("idPublication") int idPublication) {
		logger.info("---- delete publication Méthode ---");
		return iPublicationService.deletePublication(idPublication);
	}
	
	@PostMapping("/updatePublication")
	@ResponseBody
	public Publication updateUser(@RequestBody Publication publication) {
		logger.info("---- update publication Method ---");
		iPublicationService.updatePublication(publication);
		return publication;
	}
	
	// http://localhost:8082/SpringMVC/servlet/findUser/1

	@GetMapping(value = "/findPublication/{idPublication}")
	public Publication findPublication(@PathVariable("idPublication") int idPublication) {
		logger.info("---- find publication Method ---");
		return iPublicationService.findPublication(idPublication);
	}
	
	@GetMapping(value = "/findAllpublications")
	@ResponseBody
	public List<Publication> findAllpublications() {
		
		return iPublicationService.listspublications();
	}
	
}