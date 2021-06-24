package tn.esprit.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.entities.User;
import tn.esprit.services.EmailServiceImpl;
import tn.esprit.services.IUserService;

@RestController
public class RestControlUser {

	private static final Logger logger = Logger.getLogger(RestControlUser.class);

	@Autowired
	IUserService iUserService;
	@Autowired
	EmailServiceImpl emailServiceImpl;

	/*
	 * http://localhost:8082/SpringMVC/servlet/addUser {"id": 1,"firstName":
	 * "aymen","lastName": "jeddey", "email": "aymen@esprit.tn", "username":
	 * "aymenjeddey", "password": "123456","userRole": null}
	 */
	@PostMapping("/addUser")
	@ResponseBody
	public User addUser(@RequestBody User user) {
		logger.info("---- ajouter User Méthode ---");
		iUserService.addUser(user);
		emailServiceImpl.sendSimpleMessage("aymen.jeddey@esprit.tn", "test", "testtesttesttesttesttest");
		return user;
	}

	@PostMapping("/updateUser")
	@ResponseBody
	public User updateUser(@RequestBody User user) {
		logger.info("---- update User Méthode ---");
		iUserService.updateUser(user);
		return user;
	}

	@DeleteMapping(value = "/deleteUser/{idUser}")
	public User deleteUser(@PathVariable("idUser") int idUser) {
		logger.info("---- delete User Méthode ---");
		return iUserService.deleteUser(idUser);
	}

	// http://localhost:8082/SpringMVC/servlet/findUser/1

	@GetMapping(value = "/findUser/{idUser}")
	public User findUser(@PathVariable("idUser") int idUser) {
		logger.info("---- find User Méthode ---");
		return iUserService.findUser(idUser);
	}

}
