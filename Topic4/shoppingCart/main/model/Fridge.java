package shoppingCart.main.model;

import java.math.BigDecimal;

public class Fridge implements Item {

	private BigDecimal price;
	private int capacity;

	public Fridge(){
		
	}
	
	public Fridge(String price, int capacity) {
		this.price = new BigDecimal(price);;
		this.capacity = capacity;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	
	public void setPrice(String price) {
		this.price = new BigDecimal(price);;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	public String getList(){
		return "Item Fridge " + this.getCapacity() + "....... $ " + this.getPrice();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + capacity;
		result = prime * result + ((price == null) ? 0 : price.hashCode());
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
		Fridge other = (Fridge) obj;
		if (capacity != other.capacity)
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		return true;
	}

}
