package shoppingCart.main.service;

import java.math.BigDecimal;
import java.util.List;

import shoppingCart.main.model.Cart;
import shoppingCart.main.model.Item;

public class ServiceCartImp implements ServiceCart {

	@Override
	public long createCart(Cart cart) {
		// TODO Auto-generated method stub
		return 0l;
	}	
	
	@Override
	public Cart getCartBy(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addItem(long id, Item item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Item> getItems(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BigDecimal getTotalAmount(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
