package ibz.edu.spring.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ibz.edu.hib.model.Event;
import ibz.edu.spring.service.EventService;

@RestController
public class EventController {

	@Autowired
	private EventService eventService;
	
	@GetMapping("/group/{id}/event")
	public ResponseEntity<ArrayList<Event>> getEventFromGroup(@PathVariable("id") int id){
		ArrayList<Event> events = eventService.listEventsFromGroup(id);
		return ResponseEntity.ok().body(events);
	}
	
	@PostMapping("/group/{id}/event")
	public ResponseEntity<?> saveEvent(@RequestBody(required = false) Event event,
									   @PathVariable("id") int groupId){
		event.setGroupId(groupId);
		if (event.getEventDate() == null) {
			event.setEventDate(LocalDate.now());
		}
		long id = eventService.createEvent(event);
		return ResponseEntity.ok().body("New event has been saved with ID:" + id);
	}
}
