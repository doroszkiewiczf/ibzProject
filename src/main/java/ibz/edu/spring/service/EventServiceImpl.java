package ibz.edu.spring.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ibz.edu.hib.dao.EventDAO;
import ibz.edu.hib.model.Event;

@Service
@Transactional(readOnly = true)
public class EventServiceImpl implements EventService{
	
	@Autowired
	private EventDAO eventDAO;

	public ArrayList<Event> listEventsFromGroup(int groupId) {
		return eventDAO.listEventsFromGroup(groupId);
	}

	public long createEvent(Event event) {
		return eventDAO.createEvent(event);
	}
}
