package model;

public class Accessory extends Product {

	private String material;

	public Accessory(String name, String description, double purchasePrice, double salesPrice, double rentPrice,
			String country, int minStock, int stock, String material) {
		super(name, description, purchasePrice, salesPrice, rentPrice, country, minStock, stock);
		this.material = material;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}
}