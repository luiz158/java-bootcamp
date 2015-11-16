package model;

import business.RoomBuilder;

public class InternmentRoom implements RoomBuilder {

	private boolean bathroom;
	
	public String BuildingType() {
		return "Internment Room";
	}

	public void hasBathroom(boolean bathroom) {
		this.bathroom = bathroom;
	}
	
	public boolean isBathroom() {
		return bathroom;
	}

	@Override
	public String toString() {
		return this.BuildingType() + "\tBathroom: " + this.isBathroom();
	}
}
