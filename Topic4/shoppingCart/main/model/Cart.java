package shoppingCart.main.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class Cart {
	
	private long id;
	private List<Item> items = new ArrayList<Item>();
	
	public Cart(){
		
	}
	
	public Cart(long id){
		this.id = id;
	}
	
	public long getId() {
		return this.id;
	}
		
	public List<Item> getItems() {
		return items;
	}

	public void addItem(Item item){
		this.getItems().add(item);
	}

	public BigDecimal getTotalAmount(){
		BigDecimal totalAmount = new BigDecimal("0.00");
		for (Item item : items) {
			totalAmount = totalAmount.add(item.getPrice()); 
		}
		return totalAmount;
	}
	
}
