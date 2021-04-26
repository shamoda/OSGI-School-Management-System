package eventsubscriber.service;

import budgetpublisher.service.BudgetService;
import eventpublisher.service.EventService;

public interface EventSubscriberService {
	
	public void clientService(EventService eventService, BudgetService budgetService);

}
