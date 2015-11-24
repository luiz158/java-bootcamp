package meetings.src.main.java.meetings.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import meetings.src.main.java.meetings.model.Meeting;

@Repository
public interface MeetingRepository extends org.springframework.data.repository.Repository<Meeting, Long> {

	public List<Meeting> findAll();
	public Meeting save(Meeting meeting);
	public Optional<Meeting> findOne(@Param("idMeetings") Long idMeetings);
	public void delete(@Param("idMeetings") Long idMeetings);

}
