package shoppingCart.main.dao;

import shoppingCart.main.exception.CartNotFound;
import shoppingCart.main.model.Cart;

public interface DaoCart {

	public long createCart(Cart cart);

	public Cart getCartBy(long id) throws CartNotFound;

}
