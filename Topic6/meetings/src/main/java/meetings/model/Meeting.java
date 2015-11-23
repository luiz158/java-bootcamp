package meetings.src.main.java.meetings.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "meeting", catalog = "meetings_db")
public class Meeting implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Long idMeetings;
	private Room room;
	private Date startingTime;
	private Date endingTime;
	private List<Attendee> attendees = new ArrayList<Attendee>();

	public Meeting() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_meetings", unique = true, nullable = false)
	public Long getIdMeetings() {
		return this.idMeetings;
	}

	public void setIdMeetings(Long idMeetings) {
		this.idMeetings = idMeetings;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_room", nullable = false)
	public Room getRoom() {
		return this.room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "starting_time", nullable = false, length = 19)
	public Date getStartingTime() {
		return this.startingTime;
	}

	public void setStartingTime(Date startingTime) {
		this.startingTime = startingTime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ending_time", nullable = false, length = 19)
	public Date getEndingTime() {
		return this.endingTime;
	}

	public void setEndingTime(Date endingTime) {
		this.endingTime = endingTime;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "meeting_attendee", catalog = "meetings_db", joinColumns = {
			@JoinColumn(name = "id_meeting", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "id_attendee", nullable = false, updatable = false) })
	public List<Attendee> getAttendees() {
		return this.attendees;
	}

	public void setAttendees(List<Attendee> attendees) {
		this.attendees = attendees;
	}

}
