package tn.esprit.services;

import tn.esprit.entities.Product;

public interface IProductService {

	
	public int addProduct(Product product);

	public Product deleteProduct(int idProduct);

	public int updateProduct(Product product);

	public Product findProduct(int idProduct);

}
