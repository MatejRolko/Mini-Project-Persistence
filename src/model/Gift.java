package model;

public class Gift extends Product {

	private String material;

	public Gift(String name, String description, double purchasePrice, double salesPrice, double rentPrice, String countryOfOrigin,
			int minStock, int stock, String material) {
		super(name, description, purchasePrice, salesPrice, rentPrice, countryOfOrigin, minStock, stock);
		this.material = material;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

}
