package meetings.src.main.java.meetings.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import meetings.src.main.java.meetings.model.Meeting;
import meetings.src.main.java.meetings.repository.MeetingRepository;

@Service
@Transactional
public class MeetingServiceImp implements MeetingService {

	private final MeetingRepository meetingRepository;

	@Autowired
	public MeetingServiceImp(MeetingRepository meetingRepository) {
		this.meetingRepository = meetingRepository;
	}

	@Override
	public List<Meeting> getMeetings() {
		return meetingRepository.findAll();
	}

	@Override
	public Long addMeeting(Meeting meeting) {
		// TODO Auto-generated method stub
		return 0l;
	}

	@Override
	public Optional<Meeting> findById(Long idMeetings) {
		return meetingRepository.findOne(idMeetings);
	}

	@Override
	public void updateMeeting(Meeting meeting) {
		Meeting currentMeeting = this.findById(meeting.getIdMeetings()).get();

		currentMeeting.setStartingTime(meeting.getStartingTime());
		currentMeeting.setEndingTime(meeting.getEndingTime());
		currentMeeting.setRoom(meeting.getRoom());
		currentMeeting.setAttendees(meeting.getAttendees());

		meetingRepository.update(currentMeeting);
	}

	@Override
	public void deleteMeeting(Long idMeetings) {
		// TODO Auto-generated method stub

	}

}
