package model;

import java.util.List;

public class CreditCard implements PaymentStrategy {

	private String name;
	private int creditNumber;
	private final static double DISCOUNT = 0.9;
	
	public CreditCard(){
		
	}
	
	public CreditCard(String name, int creditNumber) {
		this.name = name;
		this.creditNumber = creditNumber;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getCreditNumber() {
		return creditNumber;
	}
	
	public void setCreditNumber(int creditNumber) {
		this.creditNumber = creditNumber;
	}

	public double getTotalAmount(List<Item> items) {
		double totalAmount = 0;
		for (Item item : items) {
			totalAmount += item.getPrice();
		}
		return totalAmount * DISCOUNT;
	}
	}
