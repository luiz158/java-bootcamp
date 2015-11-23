package meetings.src.main.java.meetings.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "attendee", catalog = "meetings_db")
public class Attendee implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Long idAttendee;
	private String lastName;
	private String firstName;
	private List<Meeting> meetings = new ArrayList<Meeting>();

	public Attendee() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_attendee", unique = true, nullable = false)
	public Long getIdAttendee() {
		return this.idAttendee;
	}

	public void setIdAttendee(Long idAttendee) {
		this.idAttendee = idAttendee;
	}

	@Column(name = "last_name", nullable = false, length = 20)
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "first_name", nullable = false, length = 20)
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "meeting_attendee", catalog = "meetings_db", joinColumns = {
			@JoinColumn(name = "id_attendee", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "id_meeting", nullable = false, updatable = false) })
	public List<Meeting> getMeetings() {
		return this.meetings;
	}

	public void setMeetings(List<Meeting> meetings) {
		this.meetings = meetings;
	}

}
