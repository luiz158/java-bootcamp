package meetings.src.main.java.meetings.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import meetings.src.main.java.meetings.model.Meeting;
import meetings.src.main.java.meetings.service.MeetingService;

@RestController
@RequestMapping("/")
public class MeetingController {

	@Autowired
	MeetingService meetingService;

	@RequestMapping(value = "meetings", method = RequestMethod.GET)
	// public @ResponseBody ResponseEntity<List<Meeting>> getMeetings() {
	public @ResponseBody List<Meeting> getMeetings() {
		List<Meeting> meetings = meetingService.getMeetings();
		return meetings;
		// return new ResponseEntity<> (meetings, HttpStatus.FOUND);
	}

	@RequestMapping(value = "meetings", method = RequestMethod.POST)
	public void addMeeting(@RequestBody Meeting meeting) {
		meetingService.addMeeting(meeting);
	}

	@RequestMapping(value = "meetings/{idMeetings}", method = RequestMethod.GET)
	public @ResponseBody Meeting findById(@PathVariable("idMeetings") Long idMeetings) {
		return meetingService.findById(idMeetings).get();
	}

	@RequestMapping(value = "meetings/{idMeetings}", method = RequestMethod.PUT)
	public void update(@PathVariable("idMeetings") Long idMeetings, @RequestBody Meeting meeting) {
		meetingService.updateMeeting(meeting);
	}

	@RequestMapping(value = "meetings/{idMeetings}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("idMeetings") Long idMeetings) {
		meetingService.deleteMeeting(idMeetings);
	}

}
