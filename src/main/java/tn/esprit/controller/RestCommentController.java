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
import tn.esprit.entities.User;
import tn.esprit.services.ICommentService;
import tn.esprit.services.IUserService;

@RestController
public class RestCommentController {
	
	private static final Logger logger = Logger.getLogger(RestControlUser.class);

@Autowired
ICommentService commentservice;
@Autowired
IUserService IUserService;
	
	@PostMapping("/addComment")
	@ResponseBody
	public Comment addCategory(@RequestBody Comment comment) {
		User u = IUserService.findUser(comment.getIdUser());
		comment.setUser(u);
		logger.info("---- ajouter Comment Méthode ---");
		commentservice.addComment(comment);
		return comment;
	}
	
	@PostMapping("/updateComment")
	@ResponseBody
	public Comment updatePublication(@RequestBody Comment comment) {
		logger.info("---- update Comment Method ---");
		commentservice.updateComment(comment);
		return comment;
	}

	@DeleteMapping(value = "/deleteComment/{idComment}")
	public int deleteComment(@PathVariable("idComment") int idComment) {
		logger.info("---- delete Comment Méthode ---");
		return commentservice.deleteComment(idComment);
	}

	// http://localhost:8082/SpringMVC/servlet/findUser/1

	@GetMapping(value = "/findComment/{idComment}")
	public Comment findComment(@PathVariable("idComment") int idComment) {
		logger.info("---- find Comment Méthode ---");
	
		return commentservice.findComment(idComment);
	}
	
	@GetMapping(value = "/findAllComments")
	@ResponseBody
	public List<Comment> findAllComments() {
		
		return commentservice.listComments();
	}

	
	

}