package shoppingCart.main.dao;

import java.util.ArrayList;
import java.util.List;

import shoppingCart.main.exception.CartNotFound;
import shoppingCart.main.model.Cart;

public class DaoCartImp implements DaoCart {

	private static DaoCartImp instance;
	private List<Cart> carts = new ArrayList<Cart>();
	private long lastIdCart = 0;

	private DaoCartImp() {
	}

	public static DaoCartImp getInstance() {
		if (instance == null) {
			instance = new DaoCartImp();
		}
		return instance;
	}

	@Override
	public long createCart(Cart cart) {
		this.lastIdCart = this.lastIdCart + 1;
		cart.setId(this.lastIdCart);
		this.carts.add(cart);
		return cart.getId();
	}

	@Override
	public Cart getCartBy(long id) throws CartNotFound {
		for (Cart cart : carts) {
			if (cart.getId() == id)
				return cart;
		}

		throw new CartNotFound();
	}

}
