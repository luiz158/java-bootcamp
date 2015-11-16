package model;

import business.RoomBuilder;

public class DoctorOffice implements RoomBuilder {

	private boolean bathroom;
	
	public String BuildingType() {
		return "Doctor's Office";
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
