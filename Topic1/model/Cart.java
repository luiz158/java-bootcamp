package model;

import java.util.ArrayList;
import java.util.List;

public class Cart {

	private List<Item> items = new ArrayList<Item>();
	private PaymentStrategy payment;
	private int paymentSerialNumber;
	
	public Cart(){
		
	}
	
	public Cart(List<Item> items) {
		this.items = items;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public PaymentStrategy getPayment() {
		return payment;
	}

	public void setPayment(PaymentStrategy payment) {
		this.payment = payment;
	}

	public int getPaymentSerialNumber() {
		return paymentSerialNumber;
	}

	public void setPaymentSerialNumber(int paymentSerialNumber) {
		this.paymentSerialNumber = paymentSerialNumber;
	}

	public void addItem(Item item){
		this.getItems().add(item);
	}
}
