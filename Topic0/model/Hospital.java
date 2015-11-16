package model;

import java.util.ArrayList;
import java.util.List;

public class Hospital {

	private List<DoctorOffice> doctorOffices = new ArrayList<DoctorOffice>();
	private boolean pharmacy;
	private List<InternmentRoom> internmentRooms = new ArrayList<InternmentRoom>();
	
	public Hospital(List<DoctorOffice> doctorOffices, boolean pharmacy, List<InternmentRoom> internmentRooms) {
		this.doctorOffices = doctorOffices;
		this.pharmacy = pharmacy;
		this.internmentRooms = internmentRooms;
	}
	
	public List<DoctorOffice> getDoctorOffices() {
		return doctorOffices;
	}

	public boolean isPharmacy() {
		return pharmacy;
	}

	public List<InternmentRoom> getInternmentRooms() {
		return internmentRooms;
	}

	@Override
	public String toString() {
		String description = "A Hospital with:\n";

		for (DoctorOffice room :  this.getDoctorOffices() ) {
			description += room + "\n";
		}
		description += "Total Doctor's Offices: " + this.getDoctorOffices().size() + "\n";
		
		for (InternmentRoom room : this.getInternmentRooms()) {
			description += room + "\n";
		}
		description += "Total Internment Rooms: " + this.getInternmentRooms().size() + "\n";
		
		description += "Pharmacy: " + this.isPharmacy();

		return description;
	}
	
	public static class Builder {
		
		private List<DoctorOffice> doctorOffices = new ArrayList<DoctorOffice>();
		private boolean pharmacy;
		private List<InternmentRoom> internmentRooms = new ArrayList<InternmentRoom>();
		
		public Builder hasDoctorOffices(List<DoctorOffice> doctorOffices) {
			this.doctorOffices = doctorOffices;
			return this;
		}
		
		public Builder hasPharmacy(boolean pharmacy) {
			this.pharmacy = pharmacy;
			return this;
		}
		
		public Builder hasInternmentRooms(List<InternmentRoom> internmentRooms) {
			this.internmentRooms = internmentRooms;
			return this;
		}
		
		public Hospital build(){
			Hospital hospital = new Hospital(this.doctorOffices, this.pharmacy, this.internmentRooms);
			return hospital;
		}
	}
}
