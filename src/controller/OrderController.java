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
	
	public OrderController() {
		ocd = OrderConcreteDAO.getInstance();
	}
	
	public void completeOrder() {
		ocd.create(order);
	}
	
	public Order getOrder() {
		return order;
	}
	
	public void createNewOrder() {
		order = new Order(ocd.getNextOrderId());
	}
	
	public int getCustomerId() {
		return order.getCustomerId();
	}
	
	public void addSalesLineItem(SalesLineItem item) {
		order.addSalesLineItem(item);
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
		return  order.getId();
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
	
	public ArrayList<Order> read(){
		return ocd.read();
	}
}
