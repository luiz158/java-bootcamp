package model;

import java.util.List;

public interface PaymentStrategy {

	public double getTotalAmount(List<Item> items);
}
