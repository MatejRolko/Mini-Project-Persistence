package model;

public class Customer {
	private String name;
	private String address;
	private int zipCode;
	private String city;
	private int phoneno;
	
	public Customer(String name, String address, int zipCode, String city, int phoneNumber) {
		this.name = name;
		this.address = address;
		this.zipCode = zipCode;
		this.city = city;
		this.phoneno = phoneNumber;
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


	
}
