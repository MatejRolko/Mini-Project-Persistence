package Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import controller.OrderController;

class TestCreateOrder {

	@Test public void testOrderId() {
	OrderController cntrl = new OrderController();
	cntrl.createNewOrder();
	assertEquals(1, cntrl.getId());

	}
	
	/*@Test public void testOrderDate() {
	OrderController cntrl = new OrderController();
	cntrl.createNewOrder();
	assertEquals();

	}*/
}
