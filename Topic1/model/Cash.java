package model;

import java.util.List;

public class Cash implements PaymentStrategy {

	private final static double DISCOUNT = 0.90;
	
	public double getTotalAmount(List<Item> items) {
		double totalAmount = 0;
		double mostExpensive = 0;
		for (Item item : items) {
			totalAmount += item.getPrice();
			if (item.getPrice() > mostExpensive)
				mostExpensive = item.getPrice();
		}
		return totalAmount - (mostExpensive * DISCOUNT);
	}

}
