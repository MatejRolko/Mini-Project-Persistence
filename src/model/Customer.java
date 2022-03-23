package model;

public class Customer {

	private int id;
	private String name;
	private String address;
	private int zipCode;
	private String city;
	private int phoneno;
	private boolean isBusiness;

	public Customer(String name, String address, int zipCode, String city, int phoneNumber, boolean isBusiness) {
		this.name = name;
		this.address = address;
		this.zipCode = zipCode;
		this.city = city;
		this.phoneno = phoneNumber;
		this.isBusiness = isBusiness;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPhoneNumber() {
		return phoneno;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneno = phoneNumber;
	}

	public boolean isBusiness() {
		return isBusiness;
	}

	public void setBusiness(boolean isBusiness) {
		this.isBusiness = isBusiness;
	}

}
