package shoppingCart.main.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Cart {

	private long id;
	private List<Item> items = new ArrayList<Item>();

	public Cart() {

	}

	public Cart(long id) {
		this.id = id;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Item> getItems() {
		return items;
	}

	public boolean addItem(Item item) {
		return this.getItems().add(item);
	}

	public BigDecimal getTotalAmount() {
		BigDecimal totalAmount = new BigDecimal("0.00");
		for (Item item : items) {
			totalAmount = totalAmount.add(item.getPrice());
		}
		return totalAmount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((items == null) ? 0 : items.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cart other = (Cart) obj;
		if (id != other.id)
			return false;
		if (items == null) {
			if (other.items != null)
				return false;
		} else if (!items.equals(other.items))
			return false;
		return true;
	}

}
