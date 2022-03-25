package Tests;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;

import controller.CustomerController;
import model.Customer;

public class TestGetCustomerById {
	
	@Test
	public void findCustomerById() {
		
		//Arrange
		CustomerController cntrl = new CustomerController();
		
		//Act
		Customer customer = cntrl.getCustomerById(2);
		
		//xx
		assertNotNull(customer);
		
	}

}
