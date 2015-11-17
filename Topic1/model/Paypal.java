package model;

import java.util.List;

public class Paypal implements PaymentStrategy {

	private String email;
	private String password;
	
	public Paypal(){
		
	}
	
	public Paypal(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getTotalAmount(List<Item> items) {
		double totalAmount = 0;
		double cheapest = items.get(0).getPrice();
		for (Item item : items) {
			totalAmount += item.getPrice();
			if (item.getPrice() < cheapest)
				cheapest = item.getPrice();
		}
		return totalAmount - cheapest;
	}
	
	
}
