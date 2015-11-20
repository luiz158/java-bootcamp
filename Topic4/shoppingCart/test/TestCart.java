package shoppingCart.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import shoppingCart.main.model.Cart;
import shoppingCart.main.model.Fridge;
import shoppingCart.main.model.Item;
import shoppingCart.main.model.TV;

public class TestCart {
	
	private Cart cart;
	
	@Before
	public void setUp() {
		cart = new Cart(1l);
		Item tv = new TV("10000.50", 40);
		Item fridge = new Fridge("19999.99", 70);
		cart.addItem(tv);
		cart.addItem(fridge);		
	}

	@Test
	public void testGetCartById() {
		assertEquals(1l, cart.getId());
	}
	
	@Test
	public void testGetItemList() {
		List <Item> items = new ArrayList<Item>();
		Item tv = new TV("10000.50", 40);
		Item fridge = new Fridge("19999.99", 70);
		items.add(tv);
		items.add(fridge);
		assertEquals(items, cart.getItems());
	}
	
	@Test
	public void testGetTotalAmount() {
		assertEquals("30000.49", cart.getTotalAmount().toString());
	}

}
