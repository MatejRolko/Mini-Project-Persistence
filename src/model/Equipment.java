package model;

public class Equipment extends Product {

	private String type;

	public Equipment(String name, String description, double purchasePrice, double salesPrice, double rentPrice,
			String country, int minStock, int stock, String type) {
		super(name, description, purchasePrice, salesPrice, rentPrice, country, minStock, stock);
		this.type = type;
	}

	public String getType() {
		return type; 
	}

	public void setType(String type) {
		this.type = type;
	}

}
