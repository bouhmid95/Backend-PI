package tn.esprit.services;

import tn.esprit.entities.Category;

public interface ICategoryService {
	public int addCategory(Category category);

	public Category deleteCategory(int idCategory);

	public int updateCategory(Category category);

	public Category findCategory(int idCategory);
}
