package test;

import model.House;
import model.House.Builder;

public class TestHouseBuilder {

	public static void main(String[] args) {
		House house = new Builder()
		.hasGarage(true)
		.hasGarden(false)
		.numBathrooms(4)
		.numRooms(2)
		.build();
		
		System.out.println(house);
	}
}
