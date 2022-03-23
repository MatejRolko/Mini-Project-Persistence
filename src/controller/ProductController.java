package controller;

import java.util.ArrayList;

import model.Product;
import persistence.ProductConcreteDAO;

public class ProductController {

	private ProductConcreteDAO dao;

	public ProductController() {
		dao = ProductConcreteDAO.getInstance();
	}

	public Product findProductByName(String name) {
		for (Product product : dao.read()) {
			if (product.getName().equalsIgnoreCase(name)) {
				return product;
			}
		}
		return null;
	}

	public void createProduct(Product product) {
		dao.create(product);
	}

	public void deleteProduct(Product product) {
		dao.delete(product);
	}

	public ArrayList<Product> getAllProducts() {
		return dao.read();
	}
}
