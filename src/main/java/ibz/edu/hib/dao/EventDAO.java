package ibz.edu.hib.dao;

import java.util.ArrayList;

import ibz.edu.hib.model.Event;

public interface EventDAO {

	public ArrayList<Event> listEventsFromGroup(int groupId);
	public long createEvent(Event event);
}
