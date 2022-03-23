package controll;

import model.Order;
import persistence.OrderConcreteDAO;

public class OrderController {
	private OrderConcreteDAO ocd;
	private Order order;
	
	public OrderController() {
		ocd = OrderConcreteDAO.getInstance();
	}
	
	public void createNewOrder() {
		order = new Order(ocd.getNextOrderId());
	}

}
