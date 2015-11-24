package meetings.src.main.java.meetings.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import meetings.src.main.java.meetings.model.Meeting;
import meetings.src.main.java.meetings.service.MeetingService;

@RestController
public class MeetingController {

	@Autowired
	MeetingService meetingService;

	@RequestMapping(value = "/meetings", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<Meeting>> getMeetings() {
		List<Meeting> meetings = meetingService.getMeetings();
		if(meetings.isEmpty() || meetings == null)
			return new ResponseEntity<List<Meeting>> (HttpStatus.NOT_FOUND);
		return new ResponseEntity<List<Meeting>> (meetings, HttpStatus.FOUND);
	}

	@RequestMapping(value = "/meetings", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<Void> addMeeting(@RequestBody Meeting meeting) {
		meetingService.addMeeting(meeting);
		return new ResponseEntity<Void> (HttpStatus.OK);
	}

	@RequestMapping(value = "/meetings/{idMeetings}", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<Meeting> findById(@PathVariable("idMeetings") Long idMeetings) {
		Optional<Meeting> meeting = meetingService.findById(idMeetings);
		if(!meeting.isPresent())
			return new ResponseEntity<Meeting> (HttpStatus.NOT_FOUND);
		return new ResponseEntity<Meeting> (meeting.get(), HttpStatus.OK);
	}

	@RequestMapping(value = "/meetings/{idMeetings}", method = RequestMethod.PUT)
	public @ResponseBody ResponseEntity<Void> update(@PathVariable("idMeetings") Long idMeetings, @RequestBody Meeting meeting) {
		meetingService.updateMeeting(meeting);
		return new ResponseEntity<Void> (HttpStatus.OK);
	}

	@RequestMapping(value = "/meetings/{idMeetings}", method = RequestMethod.DELETE)
	public @ResponseBody ResponseEntity<Void> delete(@PathVariable("idMeetings") Long idMeetings) {
		meetingService.deleteMeeting(idMeetings);
		return new ResponseEntity<Void> (HttpStatus.OK);
	}

}
