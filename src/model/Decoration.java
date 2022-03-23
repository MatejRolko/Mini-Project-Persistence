package model;

public class Decoration extends Product {

	private String material;
	private double weight;
	private String size;

	public Decoration(String name, String description, double purchasePrice, double salesPrice, double rentPrice,
			String country, int minStock, int stock, String material, double weight, String size, int id) {
		super(name, description, purchasePrice, salesPrice, rentPrice, country, minStock, stock, id);
		this.material = material;
		this.weight = weight;
		this.size = size;
	}

	public String getMaterial() {
		return material;
	}

	public double getWeight() {
		return weight;
	}

	public String getSize() {
		return size;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public void setSize(String size) {
		this.size = size;
	}
}