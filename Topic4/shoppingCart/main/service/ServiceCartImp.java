package shoppingCart.main.service;

import java.math.BigDecimal;
import java.util.List;

import shoppingCart.main.dao.DaoCart;
import shoppingCart.main.dao.DaoCartImp;
import shoppingCart.main.exception.CartNotFound;
import shoppingCart.main.model.Cart;
import shoppingCart.main.model.Item;

public class ServiceCartImp implements ServiceCart {

	private final DaoCart daoCart = DaoCartImp.getInstance();

	@Override
	public long createCart(Cart cart) {
		return daoCart.createCart(cart);
	}

	@Override
	public Cart getCartBy(long id) throws CartNotFound {
		return daoCart.getCartBy(id);
	}

	@Override
	public boolean addItem(long id, Item item) throws CartNotFound {
		return daoCart.getCartBy(id).addItem(item);
	}

	@Override
	public List<Item> getItems(long id) throws CartNotFound {
		return daoCart.getCartBy(id).getItems();
	}

	@Override
	public BigDecimal getTotalAmount(long id) throws CartNotFound {
		return daoCart.getCartBy(id).getTotalAmount();
	}

}
