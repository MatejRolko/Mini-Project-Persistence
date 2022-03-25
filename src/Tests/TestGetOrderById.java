package Tests;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;

import controller.CustomerController;
import controller.OrderController;
import model.Customer;
import model.Order;

public class TestGetOrderById {
	
	@Test 
	public void getOrderById() {
		//Arrange
		OrderController cntrl = new OrderController();
		
		//Act
		Order order = cntrl.getOrderById(1);
		
		//xx
		assertNotNull(order);
	}

}
