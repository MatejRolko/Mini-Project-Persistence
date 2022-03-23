package model;

public class Clothing extends Product {
	private String size;
	private String color;

	public Clothing(String name, double purchasePrice, double salesPrice, double rentPrice, String countryOfOrigin,
			int minStock, String size, String color) {
		super(name, purchasePrice, salesPrice, rentPrice, countryOfOrigin, minStock);
		this.size = size;
		this.color = color;
		
	}

	public String getSize() {
		return size;
	}

	public String getColor() {
		return color;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
