package model;

public class GunReplica extends Product {

	private String calibre;
	private String material;

	public GunReplica(String name, String description, double purchasePrice, double salesPrice, double rentPrice,
			String country, int minStock, int stock, String calibre, String material) {
		super(name, description, purchasePrice, salesPrice, rentPrice, country, minStock, stock);
		this.calibre = calibre;
		this.material = material;
	}

	public String getCalibre() {
		return calibre;
	}

	public String getMaterial() {
		return material;
	}

	public void setCalibre(String calibre) {
		this.calibre = calibre;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

}
