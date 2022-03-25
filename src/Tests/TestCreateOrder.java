package Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import controller.OrderController;
import controller.ProductController;
import model.Product;
import model.SalesLineItem;

class TestCreateOrder {
	
	@Before public static Product getProduct() {
		ProductController cntrl = new ProductController();
		return cntrl.findProductByName("greg");
	}

	@Test public void testOrderId() {
	OrderController cntrl = new OrderController();
	cntrl.createNewOrder();
	cntrl.enterSalesLineItem(new SalesLineItem(getProduct(),20));
	//assertNotNull(cntrl.getOrder()); 

	}
	
	@After
	public void after() {
		
	}
}
