package model;

public class Accessory extends Product {

	private String material;

	public Accessory(String name, String description, double purchasePrice, double salesPrice, double rentPrice,
			String country, int minStock, int stock, String material, int id) {
		super(name, description, purchasePrice, salesPrice, rentPrice, country, minStock, stock, id);
		this.material = material;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}
}