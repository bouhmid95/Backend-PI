package tn.esprit.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.entities.User;
import tn.esprit.services.IUserService;

@RestController
public class RestControlUser {

	private static final Logger logger = Logger.getLogger(RestControlUser.class);

	@Autowired
	IUserService iUserService;

	@PostMapping("/addUser")
	@ResponseBody
	public User ajouterEmploye(@RequestBody User user) {
		logger.info("---- ajouterEmploye Méthode ---");
		iUserService.addUser(user);
		return user;
	}

}
