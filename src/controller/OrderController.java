package controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import model.Order;
import model.SalesLineItem;
import persistence.OrderConcreteDAO;

public class OrderController {
	private OrderConcreteDAO ocd;
	private Order order;
	
	public Order getOrderById(int id) {
		return ocd.read(id);
	}

	public OrderController() {
		ocd = OrderConcreteDAO.getInstance();
	}

	public void createNewOrder() {
		order = new Order(ocd.getNextOrderId());
	}

	public int getCustomerId() {
		return order.getCustomerId();
	}

	public void enterSalesLineItem(SalesLineItem item) {
		order.addSalesLineItem(item);
		setPrice(getPrice() + item.getAmount() * item.getProduct().getSalesPrice());
	}

	public void setCustomerId(int id) {
		order.setCustomerId(id); 
	}

	public void setDelivery(String state) {
		order.setDelivery(state);
	}

	public String getDelivery() {
		return order.getDelivery();
	}

	public int getId() {
		return order.getId();
	}

	public double getPrice() {
		return order.getPrice();
	}

	public Date getDate() {
		return order.getDate();
	}

	public Date getDeliveryDate() {
		return order.getDeliveryDate();
	}

	public Timestamp getSqlDate() {
		return order.getSqlDate();
	}

	public Timestamp getSqlDeliveryDate() {
		return order.getSqlDeliveryDate();
	}

	public ArrayList<SalesLineItem> getProducts() {
		return order.getProducts();
	}

	public String getDeliveryStatus() {
		return order.getDeliveryStatus();
	}

	public void setId(int id) {
		order.setId(id);
	}

	public void setPrice(double price) {
		order.setPrice(price);
	}

	public void setDeliveryStatus(String deliveryOption) {
		order.setDeliveryStatus(deliveryOption);
	}

	public int getNextOrderId() {
		return ocd.getNextOrderId();
	}

	public ArrayList<Order> getAllOrders() {
		return ocd.read();
	}

	public Order findById(int id) {
		return ocd.read(id);
	}

	public void saveOrder() {

		double price = 0; 
		for (SalesLineItem item : this.getProducts()) {
			price += item.getProduct().getSalesPrice() * item.getAmount();
		}
		order.setPrice(price);
		ocd.create(order); 

		ocd.create(order);

	}
}
