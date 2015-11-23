package meetings.src.main.java.meetings.service;

import java.util.List;
import java.util.Optional;

import meetings.src.main.java.meetings.model.Meeting;

public interface MeetingService {

	public List<Meeting> getMeetings();	
	public Long addMeeting(Meeting meeting);	
	public Optional<Meeting> findById(Long idMeetings);	
	public void updateMeeting(Meeting meeting);	
	public void deleteMeeting(Long idMeetings);

}
