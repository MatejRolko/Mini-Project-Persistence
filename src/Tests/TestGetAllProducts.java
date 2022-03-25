package Tests;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import controller.CustomerController;
import controller.ProductController;
import model.Customer;
import model.Product;

public class TestGetAllProducts {
	
	@Test
	public void getAllProducts() {
		//Arrange
		ArrayList<Product> products = new ArrayList<Product>();
		ProductController cntrl = new ProductController();
		
		//Act
		products = cntrl.getAllProducts();
		
		//xx
		assertNotNull(products);
	}

}
