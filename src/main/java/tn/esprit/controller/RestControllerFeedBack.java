package tn.esprit.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.entities.Feedback;
import tn.esprit.entities.Order;
import tn.esprit.entities.User;
import tn.esprit.services.FeedbackServiceImpl;
import tn.esprit.services.OrderServiceImpl;

@RestController
public class RestControllerFeedBack {
	
	private static final Logger logger = Logger.getLogger(RestControllerFeedBack.class);

	@Autowired
	private FeedbackServiceImpl feedbackService;
	
	@PostMapping("/addFeedback")
	@ResponseBody
	public Feedback addOrder(@RequestBody Feedback feedback) {
		this.feedbackService.addFeedback(feedback);
		return feedback ;
	}
	
	@PutMapping("/updateFeedback")
	@ResponseBody
	public Feedback updateFeedback(@RequestBody Feedback feedback) {
		this.feedbackService.updateFeedback(feedback);
		return feedback;
	}
	
	@DeleteMapping(value = "/deleteFeedback/{idFeedback}")
	public String deletFeedback(@PathVariable("idFeedback") int idFeedback) {
		this.feedbackService.deleteFeedback(idFeedback);
		return "Order N° " + idFeedback + " deleted" ;
	}
	
	@GetMapping("/ListFeedback")
	public List<Feedback> findAllOrder() {
		return this.feedbackService.findAllFeedBack();
	}


}
