package model;

public class Fridge implements Item {

	private int serialNumber;
	private double price;
	private int capacity;

	public Fridge(){
		
	}
	
	public Fridge(int serialNumber, double price, int capacity) {
		this.serialNumber = serialNumber;
		this.price = price;
		this.capacity = capacity;
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
	public String toString(){
		return "Serial Number: " + this.getSerialNumber() + "\tPrice: $" + this.getPrice() + "\tCapacity: " + this.getCapacity() + "L\n";
	}
}
