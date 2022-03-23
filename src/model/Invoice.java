package model;

public class Invoice {
	private int inoviceNo;
	private String orderDate;
	private int amount;
	public int getInoviceNo() {
		return inoviceNo;
	}
	public void setInoviceNo(int inoviceNo) {
		this.inoviceNo = inoviceNo;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}

}
