package model;

import java.util.ArrayList;

public class Order {

	private int id;
	private double price;
	private String date;
	private ArrayList<Product> products;
	private String deliveryOption;

	public Order(double price, String date, ArrayList<Product> products, String deliveryOption) {
		this.price = price;
		this.date = date;
		this.products = products;
		this.deliveryOption = deliveryOption;
	}

	public int getId() {
		return id;
	}

	public double getPrice() {
		return price;
	}

	public String getDate() {
		return date;
	}

	public ArrayList<Product> getProducts() {
		return products;
	}

	public String getDeliveryOption() {
		return deliveryOption;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}

	public void setDeliveryOption(String deliveryOption) {
		this.deliveryOption = deliveryOption;
	}

}
