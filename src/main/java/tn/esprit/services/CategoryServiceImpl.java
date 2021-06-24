package tn.esprit.services;

import java.util.List;

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
		categoryRepository.deleteById(idCategory);
		return category;
	}

	@Override
	public int updateCategory(Category category) {
		Category categoryOld = categoryRepository.findById(category.getId()).orElse(null);
		
		categoryOld.setCode(category.getCode());
		categoryOld.setName(category.getName());
		
		categoryRepository.save(categoryOld);
		return categoryOld.getId();
	}

	@Override
	public Category findCategory(int idCategory) {
		
		return categoryRepository.findById(idCategory).orElse(null);
	}

	@Override
	public List<Category> findAllCategory() {
		// TODO Auto-generated method stub
		return (List<Category>) categoryRepository.findAll() ;
	}

}
