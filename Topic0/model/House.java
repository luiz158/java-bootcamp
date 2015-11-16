package model;

public class House {

	private int rooms;
	private int bathrooms;
	private boolean garden;
	private boolean garage;

	public House(int rooms, int bathrooms, boolean garden, boolean garage) {
		this.rooms = rooms;
		this.bathrooms = bathrooms;
		this.garden = garden;
		this.garage = garage;
	}

	public int getRooms() {
		return rooms;
	}

	public int getBathrooms() {
		return bathrooms;
	}

	public boolean isGarden() {
		return garden;
	}

	public boolean isGarage() {
		return garage;
	}

	@Override
	public String toString() {
		return "House\n*************\nRooms: " + getRooms() + "\nBathrooms: " + getBathrooms() + "\nGarden: " + isGarden() + "\nGarage: " + isGarage();
	}

	public static class Builder {

		private int rooms;
		private int bathrooms;
		private boolean garden;
		private boolean garage;

		public Builder numRooms(int rooms) {
			this.rooms = rooms;
			return this;
		}

		public Builder numBathrooms(int bathrooms) {
			this.bathrooms = bathrooms;
			return this;
		}

		public Builder hasGarden(boolean garden) {
			this.garden = garden;
			return this;
		}

		public Builder hasGarage(boolean garage) {
			this.garage = garage;
			return this;
		}

		public House build() {
			House house = new House(this.rooms, this.bathrooms, this.garden, this.garage);
			return house;
		}
	}
}
