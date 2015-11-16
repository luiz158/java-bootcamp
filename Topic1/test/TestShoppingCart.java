package test;

import business.Sequence;
import model.Fridge;
import model.TV;

public class TestShoppingCart {

	public static void main(String[] args) {		
		
		TV tv1 = new TV(1, 5000, 32);
		TV tv2 = new TV(2, 7000, 40);
		
		Fridge fridge1 = new Fridge(3, 10000, 40);
		Fridge fridge2 = new Fridge(4, 15000, 60);
		
		// Buy different items. 
		
		// Decide how to pay. 
		// Discount depending on the payment type.
		
		// Unique sequential numbers and use it to set an identification to each payment transaction.
		Sequence counter; 
		
		// Display information about the list of items.
		// Item Name ....... $ price.
		
	}
}
