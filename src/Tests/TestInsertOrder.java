package Tests;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import controller.OrderController;
import model.Order;

public class TestInsertOrder {
	
	@Before
	public void beforeInsert() {
		
	}
	
	
	@Test
	public void insertOrder() {
		OrderController cntrl = new OrderController();
		cntrl.createNewOrder();
		cntrl.addSalesLineItem(null);
		cntrl.setCustomerId(3);
		cntrl.setDelivery("yes");
		
	}
	
	@After
	public void afterInsert() {
		
	}
	

}
