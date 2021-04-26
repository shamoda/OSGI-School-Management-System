package eventsubscriber.service;

import java.util.Scanner;

import budgetpublisher.service.BudgetService;
import eventpublisher.service.EventService;

import static eventsubscriber.constant.EventSubscriberConstant.*;

public class EventSubscriberServiceImpl implements EventSubscriberService {
	
	Scanner sc = new Scanner(System.in);

	@Override
	public void clientService(EventService eventService, BudgetService budgetService) {
		
		while(true) {
			System.out.println();
			System.out.println("========== Welcome to Event Management Portal. ==========");
			System.out.println();
			System.out.println("> To Manage Events enter: events ");
			System.out.println("> To Manage Budgets enter: budgets ");
			System.out.println("> To Exit enter: exit ");
			System.out.print("> ");
			
			String input = sc.nextLine();
			
			if(input.equalsIgnoreCase(EVENTS)) {
				ManageEvents me = new ManageEventsImpl();
				me.clientEvent(eventService);
			}
			else if(input.equalsIgnoreCase(BUDGETS)) {
				ManageBudget mb = new ManageBudgetImpl();
				mb.clientBudget(eventService, budgetService);
			}
			else if(input.equalsIgnoreCase(EXIT)) {
				System.out.println();
				System.out.println("========== Thank You ==========");
				return;
			}
			else {
				System.out.println("Invalid command. Please try again.");
			}
		}
	}

}
