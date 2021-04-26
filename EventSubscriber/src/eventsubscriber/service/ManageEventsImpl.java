package eventsubscriber.service;

import java.util.List;
import java.util.Scanner;

import eventpublisher.model.Event;
import eventpublisher.service.EventService;
import static eventsubscriber.constant.EventSubscriberConstant.*;

public class ManageEventsImpl implements ManageEvents {
	
	String id;
	String name;
	String desc;
	String date;
	Scanner sc = new Scanner(System.in);

	@Override
	public void clientEvent(EventService eventService) {
		
		System.out.println();
		System.out.println("Please select the service you want.");
		
		while(true) {
			id = null;
			name = null;
			desc = null;
			date = null;
			String input = getServiceInput();
			
			if(input.equalsIgnoreCase(EXIT)) {
				return;
			}
			else if(input.equalsIgnoreCase(ADD)) {
				addEvent(eventService);
			}
			else if(input.equalsIgnoreCase(ALL)) {
				getAllEvents(eventService);
			}
			else if(input.equalsIgnoreCase(EVENT)) {
				getEvent(eventService);
			}
			else if(input.equalsIgnoreCase(UPDATE)) {
				updateEvent(eventService);
			}
			else if(input.equalsIgnoreCase(DELETE)) {
				deleteEvent(eventService);
			}
			else {
				System.out.println("Invalid command. Try again.");
			}
			
			System.out.print("Is there any other service you want to get?(yes/no): ");
			String end = sc.nextLine();
			if(end.equalsIgnoreCase(NO)) {
				return;
			}
			else if(!end.equalsIgnoreCase(YES)) {
				System.out.println("Invalid command. Try again.");
			}
		}
	}
	
	
	public String getServiceInput() {
		System.out.println("> To add new event enter: add");
		System.out.println("> To view all events: all");
		System.out.println("> To view event details enter: event");
		System.out.println("> To update an event enter: update");
		System.out.println("> To delete an event enter: delete");
		System.out.println("> To exit enter: exit");
		System.out.print("> ");
		String tempInput = sc.nextLine();
		System.out.println();
		
		return tempInput;
	}
	
	public void addEvent(EventService eventService) {
		System.out.print("Event ID: ");
		id = sc.nextLine();
		System.out.print("Event name: ");
		name = sc.nextLine();
		System.out.print("Event description: ");
		desc = sc.nextLine();
		System.out.print("Event date: ");
		date = sc.nextLine();
		System.out.println();
		
		String tem = eventService.addEvent(id, name, desc, date);
		System.out.println(tem);
		System.out.println();
	}
	
	public void getAllEvents(EventService eventService) {
		List<Event> events = eventService.getAllEvents();
		
	    System.out.println("Event List: "); 		
	    for (Event event : events) {
	    	System.out.println();
	    	System.out.println("ID: " + event.getId());
	        System.out.println("Name: " + event.getName());
	        System.out.println("Description: " + event.getDescription());
	        System.out.println("Date: " + event.getDate());
	        System.out.println();
	    }
	}
	
	public void getEvent(EventService eventService) {
		String tempId;
		System.out.print("Enter event ID: ");
		tempId = sc.nextLine();
		Event event = eventService.getEvent(tempId);
		if(event != null) {
			System.out.println();
			System.out.println("ID: " + event.getId());
			System.out.println("Name: " + event.getName());
			System.out.println("Description: " + event.getDescription());
			System.out.println("Date: " + event.getDate());
			System.out.println();
		}
	}
	
	public void updateEvent(EventService eventService) {
		String tempId;
		System.out.print("Enter event ID you want to update: ");
		tempId = sc.nextLine();
		Event event = eventService.getEvent(tempId);
		if(event != null) {
			System.out.println("Existing event details,");
			System.out.println("ID: " + event.getId());
			System.out.println("Name: " + event.getName());
			System.out.println("Description: " + event.getDescription());
			System.out.println("Date: " + event.getDate());
			System.out.println();
			
			System.out.println("ID: " + event.getId());
			System.out.print("Event's new name: ");
			name = sc.nextLine();
			System.out.print("Event's new description: ");
			desc = sc.nextLine();
			System.out.print("Event's new date: ");
			date = sc.nextLine();
			System.out.println();
			
			Event newEvent = new Event(tempId, name, desc, date);
			eventService.updateEvent(tempId, newEvent);
		}
	}
	
	public void deleteEvent(EventService eventService) {
		String tempId;
		System.out.print("Enter event ID you want to delete: ");
		tempId = sc.nextLine();
		eventService.deleteEvent(tempId);
	}

}
