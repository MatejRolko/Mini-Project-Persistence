package Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import controller.CustomerController;
import controller.OrderController;
import controller.ProductController;
import model.Product;
import model.SalesLineItem;

class TestSaveOrder {

	@Test public void testSaveOrder() {
		
	//Arrange
	OrderController cntrl = new OrderController();
	ProductController pcntrl = new ProductController();
	int sizeBefore = cntrl.getAllOrders().size();

	
	//Assert
	cntrl.createNewOrder();
	cntrl.enterSalesLineItem(new SalesLineItem(pcntrl.findProductByName("greg"),20));
	cntrl.setCustomerId(1);
	cntrl.setDelivery(null);
	cntrl.saveOrder();
	
	//Act
	assertEquals(sizeBefore, cntrl.getAllOrders().size() -1);
	}

}
