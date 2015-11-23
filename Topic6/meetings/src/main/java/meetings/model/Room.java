package meetings.src.main.java.meetings.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "room", catalog = "meetings_db")
public class Room implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Long idRoom;
	private String name;
	private List<Meeting> meetings = new ArrayList<Meeting>();

	public Room() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_room", unique = true, nullable = false)
	public Long getIdRoom() {
		return this.idRoom;
	}

	public void setIdRoom(Long idRoom) {
		this.idRoom = idRoom;
	}

	@Column(name = "name", nullable = false, length = 20)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "room")
	public List<Meeting> getMeetings() {
		return this.meetings;
	}

	public void setMeetings(List<Meeting> meetings) {
		this.meetings = meetings;
	}

}
