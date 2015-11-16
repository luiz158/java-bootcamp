package business;

import model.DoctorOffice;
import model.InternmentRoom;

public class RoomFactory {

	public RoomBuilder getTypeBuilding(int type) {
		if ("1".equals(Integer.toString(type))) {
			return new DoctorOffice();
		} else {
			return new InternmentRoom();
		}
	}
}
