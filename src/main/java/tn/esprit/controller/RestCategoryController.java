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

import tn.esprit.entities.Category;
import tn.esprit.services.ICategoryService;

@RestController
public class RestCategoryController {
	private static final Logger logger = Logger.getLogger(RestControlUser.class);
	
	@Autowired
	ICategoryService categoryService;
	
	@PostMapping("/updateCategory")
	@ResponseBody
	public Category updateCategory(@RequestBody Category category) {
		logger.info("---- update Category Méthode ---");
		categoryService.updateCategory(category);
		return category;
	}

	@DeleteMapping(value = "/deleteUser/{idcategory}")
	public Category deleteCategory(@PathVariable("idcategory") int idCategory) {
		logger.info("---- delete category Méthode ---");
		return categoryService.deleteCategory(idCategory);
	}

	// http://localhost:8082/SpringMVC/servlet/findUser/1

	@GetMapping(value = "/findCategory/{idCategory}")
	public Category findCategory(@PathVariable("idCategory") int idCategory) {
		logger.info("---- find category Méthode ---");
		
		logger.debug("This is a debug message");
		logger.info("This is an info message");
		logger.warn("This is a warn message");
		logger.error("This is an error message");
		return categoryService.findCategory(idCategory);
	}

	
	

}
