package shoppingCart.main.dao;

import java.util.ArrayList;
import java.util.List;

import shoppingCart.main.model.Cart;

public class DaoCartImp implements DaoCart {

	private static DaoCartImp instance;
	private List<Cart> carts = new ArrayList<Cart>();
	
	public static DaoCartImp getInstance() {
	      if(instance == null) {
	         instance = new DaoCartImp();
	      }
	      return instance;
	   }
	
	@Override
	public long createCart(Cart cart) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Cart getCartBy(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
