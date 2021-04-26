package eventpublisher.service;

import java.util.ArrayList;
import java.util.List;

import eventpublisher.model.Event;

public class EventServiceImpl implements EventService {
	
	public List<Event> events = new ArrayList<Event>();

	@Override
	public String addEvent(String id, String name, String des, String date) {
		Event event = new Event(id, name, des, date);
		events.add(event);
		return "New event " + event.getName() + " added successfully.";
	}

	@Override
	public List<Event> getAllEvents() {
		return events;
	}

	@Override
	public Event getEvent(String id) {
		Event event = null;
	    for (Event tempEvent : events) { 		      
	    	if(tempEvent.getId().equalsIgnoreCase(id)) {
	    		event = tempEvent;
	    	}
	    }
	    
	    if(event == null) {
	    	System.out.println("Sorry there is no such event");
    		System.out.println();
	    	return null;
	    }
	    
	    return event;
	}

	@Override
	public void deleteEvent(String id) {
	    for (Event tempEvent : events) { 		      
	    	if(tempEvent.getId().equalsIgnoreCase(id)) {
	    		System.out.println();
	    		System.out.println(tempEvent.getName() + " event deleted successfully.");
	    		System.out.println();
	    		events.remove(tempEvent);
	    		return;
	    	}
	    }
	    System.out.println("Sorry!!! There is no such event to delete");
	    System.out.println();
	}

	@Override
	public void updateEvent(String id, Event event) {
	    for (Event tempEvent : events) { 		      
	    	if(tempEvent.getId().equalsIgnoreCase(id)) {
	    		events.remove(tempEvent);
	    		events.add(event);
	    		System.out.println(event.getId() + " event updated successfully");
	    		return;
	    	}
	    }
	    System.out.println("Sorry!!! There is no such event to update");
	}

	@Override
	public boolean checkEvent(String id) {
	    for (Event tempEvent : events) { 		      
	    	if(tempEvent.getId().equalsIgnoreCase(id)) {
	    		return true;
	    	}
	    }
		return false;
	}

}
