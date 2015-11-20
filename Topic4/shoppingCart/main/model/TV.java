package shoppingCart.main.model;

import java.math.BigDecimal;

public class TV implements Item {

	private BigDecimal price;
	private double screenSize;

	public TV() {
		
	}
	
	public TV(String price, double screenSize) {
		this.price = new BigDecimal(price); // I don't know if it's right
		this.screenSize = screenSize;
	}
	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = new BigDecimal(price);
	}

	public double getScreenSize() {
		return this.screenSize;
	}
	
	public String getList(){
		return "Item TV " + this.getScreenSize() + "....... $ " + this.getPrice();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		long temp;
		temp = Double.doubleToLongBits(screenSize);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		TV other = (TV) obj;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (Double.doubleToLongBits(screenSize) != Double.doubleToLongBits(other.screenSize))
			return false;
		return true;
	}
	
}
