package model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Order {

	private int id;
	private double price;
	private java.util.Date date;
	private java.util.Date deliveryDate;
	private ArrayList<SalesLineItem> products;
	private String deliveryStatus;
	private String delivery;
	private int customerId;

	public Order(int id) {
		this.id = id;
		ArrayList<SalesLineItem> products = new ArrayList<SalesLineItem>();
		this.date = Calendar.getInstance().getTime();
		this.deliveryDate = Calendar.getInstance().getTime();
	}
	
	public Order(int id, Date date, int amount, Date deliveryDate,
			String deliveryStatus, String delivery, int customer_id) {
		this.id = id;
		this.date = date;
		this.price = amount;
		this.deliveryDate = deliveryDate;
		this.deliveryStatus = deliveryStatus;
		this.delivery = delivery;
		this.customerId = customer_id;
		
	}
	
	public int getCustomerId() {
		return customerId;
	}
	
	public void addSalesLineItem(SalesLineItem item) {
		products.add(item);
	}
	
	public void setCustomerId(int id) {
		customerId = id;
	}
	
	public void setDelivery(String state) {
		delivery = state;
	}
	
	public String getDelivery() {
		return delivery;
	}

	public int getId() {
		return id;
		
		
	}

	public double getPrice() {
		return price;
	}

	public Date getDate() {
		return date;
	}
	
	public Date getDeliveryDate() {
		return deliveryDate;
	}
	
	public Timestamp getSqlDate() {
		java.util.Date dateTime = this.getDate();
		java.sql.Timestamp sqlTime = new java.sql.Timestamp(dateTime.getTime());
		return sqlTime;
	}
	
	public Timestamp getSqlDeliveryDate() {
		java.util.Date dateTime = this.getDeliveryDate();
		java.sql.Timestamp sqlTime = new java.sql.Timestamp(dateTime.getTime());
		return sqlTime;
	}

	public ArrayList<SalesLineItem> getProducts() {
		return products;
	}

	public String getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setDeliveryStatus(String deliveryOption) {
		this.deliveryStatus = deliveryOption;
	}

}
