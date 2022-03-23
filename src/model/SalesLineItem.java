package model;

public class SalesLineItem {

	private int amount;
	private Product product;
	
	public SalesLineItem(int amount, Product product) {
		this.amount = amount;
		this.product = product;
	}

	public int getAmount() {
		return amount;
	}

	public Product getProduct() {
		return product;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	
}
