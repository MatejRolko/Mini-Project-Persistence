package Tests;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import controller.OrderController;

public class TestGetNextOrderId {
	
	@Test
	public void testGetNextOrderId() {
		//Arrange
		OrderController cntrl = new OrderController();
		
		//Assert
		int id = cntrl.getNextOrderId();
		
		//Act
		assertEquals(12, id);
	}

}
