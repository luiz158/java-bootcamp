package shoppingCart.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import shoppingCart.main.exception.CartNotFound;
import shoppingCart.main.model.Cart;
import shoppingCart.main.model.Item;
import shoppingCart.main.model.TV;
import shoppingCart.main.service.ServiceCart;
import shoppingCart.main.service.ServiceCartImp;

public class TestServiceCart {

	private ServiceCart serviceCart = new ServiceCartImp();
	private Item tv = new TV("10000.50", 40);

	@Before
	public void setUp() {
		serviceCart.createCart(new Cart());
	}

	@Test
	public void testCreateCart() {
		assertEquals(5, serviceCart.createCart(new Cart()));
	}

	@Test
	public void testGetCart() {
		try {
			Cart cart = new Cart(1);
			assertEquals(cart, serviceCart.getCartBy(1));
		} catch (CartNotFound e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testAddItem() {
		try {
			assertEquals(true, serviceCart.addItem(2, tv));
		} catch (CartNotFound e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testGetItems() {
		try {
			assertEquals(tv, serviceCart.getItems(2).get(0));
		} catch (CartNotFound e) {
			System.out.println(e.getMessage());
		}
	}

}
