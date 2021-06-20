package tn.esprit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.entities.Category;
import tn.esprit.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements ICategoryService {
	
	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public int addCategory(Category category) {
		categoryRepository.save(category);
		return category.getId();
	}

	@Override
	public Category deleteCategory(int idCategory) {
		Category category = categoryRepository.findById(idCategory).orElse(null);
		return category;
	}

	@Override
	public int updateCategory(Category category) {
		Category categoryOld = categoryRepository.findById(category.getId()).orElse(null);
		return category.getId();
	}

	@Override
	public Category findCategory(int idCategory) {
		
		return categoryRepository.findById(idCategory).orElse(null);
	}

}
