package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import business.RoomBuilder;
import business.RoomFactory;
import model.DoctorOffice;
import model.Hospital;
import model.InternmentRoom;
import model.Hospital.Builder;

public class TestHospital {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		RoomFactory roomFactory = new RoomFactory();
		List<DoctorOffice> doctorOffices = new ArrayList<DoctorOffice>();
		List<InternmentRoom> internmentRooms = new ArrayList<InternmentRoom>();
		int type;
		
		try {	
			//Create rooms	
	    	do {
				System.out.println("What kind of room do you want to create?\n1-Doctor's Office\n2-InternmentRoom\n3-Exit");
				type = Integer.parseInt(scanner.nextLine());
				
				if (type < 0 || type >=4) throw new Exception ("Please, look at options!"); 
				if (type == 3) break;
				
				RoomBuilder room = roomFactory.getTypeBuilding(type);
				if (room instanceof DoctorOffice) {
					room.hasBathroom(false);
					doctorOffices.add((DoctorOffice) room);
				} else {
					room.hasBathroom(true);
					internmentRooms.add((InternmentRoom) room);
				}
	    	} while (type != 3);
	    	
			Hospital hospital = new Builder()
					.hasDoctorOffices(doctorOffices)
					.hasInternmentRooms(internmentRooms)
					.hasPharmacy(true)
					.build();
			
			System.out.println(hospital);
			
		} catch (NumberFormatException e) {
			System.out.println("Please, only numbers!");
		}
		
		catch (Exception e){
			System.out.println(e);
		}
	}
}
