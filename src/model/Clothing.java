package model;

import java.awt.Color;

public class Clothing extends Product {
	private String size;
	private Color color;
	
	public Clothing(String name, double purchasePrice, double salesPrice, double rentPrice, String countryOfOrigin,
			int minStock) {
		super(name, purchasePrice, salesPrice, rentPrice, countryOfOrigin, minStock);
		// TODO Auto-generated constructor stub
	}

}
