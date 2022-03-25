package Runner;

import java.util.Calendar;

import controller.OrderController;
import controller.ProductController;
import model.Order;
import model.Product;
import model.SalesLineItem;
import persistence.Database;

public class Runner {
	public static void main(String[] args) {
		//Arrange
		OrderController cntrl = new OrderController();
		ProductController pcntrl = new ProductController();
		int sizeBefore = cntrl.getAllOrders().size();
		System.out.print(sizeBefore);
		
		//Assert
		cntrl.createNewOrder();
		cntrl.enterSalesLineItem(new SalesLineItem(pcntrl.findProductByName("greg"),20));
		cntrl.setCustomerId(1);
		cntrl.setDelivery(null);
		cntrl.saveOrder();
		
		System.out.print(cntrl.getAllOrders().size());
	}
}
