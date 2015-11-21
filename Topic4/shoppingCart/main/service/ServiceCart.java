package shoppingCart.main.service;

import java.math.BigDecimal;
import java.util.List;

import shoppingCart.main.exception.CartNotFound;
import shoppingCart.main.model.Cart;
import shoppingCart.main.model.Item;

public interface ServiceCart {

	public long createCart(Cart cart);

	public Cart getCartBy(long id) throws CartNotFound;

	public boolean addItem(long id, Item item) throws CartNotFound;

	public List<Item> getItems(long id) throws CartNotFound;

	public BigDecimal getTotalAmount(long id) throws CartNotFound;

}
