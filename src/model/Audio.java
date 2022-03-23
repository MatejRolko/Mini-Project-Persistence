package model;

public class Audio extends Product {

	private int noOfTracks;
	private int lenght;
	private String author;

	public Audio(String name, String description, double purchasePrice, double salesPrice, double rentPrice,
			String country, int minStock, int stock, int noOfTracks, int lenght, String author, int id) {
		super(name, description, purchasePrice, salesPrice, rentPrice, country, minStock, stock, id);
		this.noOfTracks = noOfTracks;
		this.lenght = lenght;
		this.author = author;
	}

	public int getNoOfTracks() {
		return noOfTracks;
	}

	public int getLenght() {
		return lenght;
	}

	public String getAuthor() {
		return author;
	}

	public void setNoOfTracks(int noOfTracks) {
		this.noOfTracks = noOfTracks;
	}

	public void setLenght(int lenght) {
		this.lenght = lenght;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}
