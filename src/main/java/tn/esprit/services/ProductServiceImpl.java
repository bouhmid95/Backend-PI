package tn.esprit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.entities.Product;
import tn.esprit.repository.ProductRepository;
@Service
public class ProductServiceImpl implements IProductService {
	
	@Autowired
	ProductRepository productRepository;

	@Override
	public int addProduct(Product product) {
		productRepository.save(product);
		return product.getId();
	}

	@Override
	public Product deleteProduct(int idProduct) {
		Product product = productRepository.findById(idProduct).orElse(null);
		productRepository.delete(product);
		return product;
	}

	@Override
	public int updateProduct(Product product) {
		Product oldProduct = productRepository.findById(product.getId()).orElse(null);
		oldProduct.setTitle(oldProduct.getTitle());
		oldProduct.setCategory(product.getCategory());
		oldProduct.setPublicationDate(product.getPublicationDate());
		
		return product.getId();
	}

	@Override
	public Product findProduct(int idProduct) {
		
		return productRepository.findById(idProduct).orElse(null);
	}

}
