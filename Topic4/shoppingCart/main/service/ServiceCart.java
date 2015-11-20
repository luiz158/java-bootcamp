package shoppingCart.main.service;

import java.math.BigDecimal;
import java.util.List;

import shoppingCart.main.model.Cart;
import shoppingCart.main.model.Item;

public interface ServiceCart {

	public long createCart(Cart cart);
	public Cart getCartBy(long id);	
	public boolean addItem(long id, Item item);
	public List<Item> getItems(long id);
	public BigDecimal getTotalAmount(long id);

}
