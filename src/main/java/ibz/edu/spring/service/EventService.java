package ibz.edu.spring.service;

import java.util.ArrayList;

import ibz.edu.hib.model.Event;

public interface EventService {
	public ArrayList<Event> listEventsFromGroup(int groupId);
	public long createEvent(Event event);
}
