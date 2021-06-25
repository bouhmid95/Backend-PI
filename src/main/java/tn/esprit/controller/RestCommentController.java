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
import tn.esprit.services.ICommentService;

@RestController
public class RestCommentController {
	
	private static final Logger logger = Logger.getLogger(RestControlUser.class);

@Autowired
ICommentService commentservice;
	
	@PostMapping("/addComment")
	@ResponseBody
	public Comment addCategory(@RequestBody Comment comment) {
		logger.info("---- ajouter Comment Méthode ---");
		commentservice.addComment(comment);
		return comment;
	}
	
//	@PostMapping("/updateCategory")
//	@ResponseBody
//	public Category updateCategory(@RequestBody Category category) {
//		logger.info("---- update Comment Méthode ---");
//		categoryService.updateCategory(category);
//		return category;
//	}

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