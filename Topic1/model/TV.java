package model;

public class TV implements Item {

	private int serialNumber;
	private double price;
	private double screenSize;

	public TV() {
		
	}
	
	public TV(int serialNumber, double price, double screenSize) {
		this.serialNumber = serialNumber;
		this.price = price;
		this.screenSize = screenSize;
	}
	
	public int getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getScreenSize() {
		return this.screenSize;
	}
	
	public void setScreenSize(double screenSize) {
		this.screenSize = screenSize;
	}
	
	public String getList(){
		return "Item TV " + this.getScreenSize() + "....... $ " + this.getPrice();
	}

	@Override
	public String toString(){
		return "Serial Number: " + this.getSerialNumber() + "\tPrice: $" + this.getPrice() + "\tScreenSize: " + this.getScreenSize() + "\n";
	}
	
}
