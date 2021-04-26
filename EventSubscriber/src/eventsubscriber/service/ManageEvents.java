package eventsubscriber.service;

import eventpublisher.service.EventService;

public interface ManageEvents {
	
	public void clientEvent(EventService eventService);
	
	public String getServiceInput();
	
	public void addEvent(EventService eventService);
	
	public void getAllEvents(EventService eventService);
	
	public void getEvent(EventService eventService);
	
	public void updateEvent(EventService eventService);
	
	public void deleteEvent(EventService eventService);

}
