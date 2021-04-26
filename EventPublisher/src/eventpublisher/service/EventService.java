package eventpublisher.service;

import java.util.List;

import eventpublisher.model.Event;

public interface EventService {
	
	public String addEvent(String id, String name, String des, String date);
	
	public List<Event> getAllEvents();
	
	public Event getEvent(String id);
	
	public void deleteEvent(String id);
	
	public void updateEvent(String id, Event event);
	
	public boolean checkEvent(String id);

}
