package test;

import business.Sequence;
import model.Cart;
import model.Cash;
import model.CreditCard;
import model.Fridge;
import model.Item;
import model.Paypal;
import model.TV;

public class TestShoppingCart {

	public static void main(String[] args) {		
		
		// Create items.
		TV tv1 = new TV(1, 5000, 32);		
		Fridge fridge1 = new Fridge(2, 10000, 40);
		
		// Buy different items. 
		Cart cart = new Cart();
		cart.addItem(tv1);
		cart.addItem(fridge1);
		
		// Decide how to pay. 
		cart.setPayment(new CreditCard("VISA", 123456789));
		System.out.println("Price with Credit Card: " + cart.getPayment().getTotalAmount(cart.getItems()));
		cart.setPayment(new Paypal("mymail@domain.com", "123456"));
		System.out.println("Price with Paypal: " + cart.getPayment().getTotalAmount(cart.getItems()));
		cart.setPayment(new Cash());
		System.out.println("Price with Cash: " + cart.getPayment().getTotalAmount(cart.getItems()));
		
		// Unique sequential numbers and use it to set an identification to each payment transaction.
		cart.setPaymentSerialNumber(Sequence.getInstance().getNext());
		System.out.println("ID payment transaction: " + cart.getPaymentSerialNumber());
		
		// Display information about the list of items.
		for (Item item : cart.getItems()) {
			System.out.println(item.getList());
		}
		
	}
}
