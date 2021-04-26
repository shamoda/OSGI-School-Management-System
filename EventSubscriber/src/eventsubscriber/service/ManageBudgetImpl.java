package eventsubscriber.service;

import static eventsubscriber.constant.EventSubscriberConstant.*;

import java.util.List;
import java.util.Scanner;

import budgetpublisher.model.Budget;
import budgetpublisher.service.BudgetService;
import eventpublisher.service.EventService;

public class ManageBudgetImpl implements ManageBudget {
	
	String id;
	double venue;
	double deco;
	double foodBeverages;
	double awards;
	double other;
	double total;
	String end;
	Scanner sc = new Scanner(System.in);

	@Override
	public void clientBudget(EventService eventService, BudgetService budgetService) {
		
		System.out.println();
		System.out.println("Please select the service you want.");
		
		while(true) {
			id = null;
			venue = 0;
			deco = 0;
			foodBeverages = 0;
			awards = 0;
			other = 0;
			total = 0;
			end = null;
			String input = getServiceInput();
			
			if(input.equalsIgnoreCase(EXIT)) {
				return;
			}
			else if(input.equalsIgnoreCase(ADD)) {
				addBudget(eventService, budgetService);
			}
			else if(input.equalsIgnoreCase(ALL)) {
				getAllBudgets(budgetService);
			}
			else if(input.equalsIgnoreCase(BUDGET)) {
				getBudget(budgetService);
			}
			else if(input.equalsIgnoreCase(UPDATE)) {
				updateBudget(budgetService);
			}
			else if(input.equalsIgnoreCase(DELETE)) {
				deleteBudget(budgetService);
			}
			else {
				System.out.println("Invalid command. Try again.");
			}
			
			System.out.print("Is there any other service you want to get?(yes/no): ");
			System.out.println();
			end = sc.nextLine();
			if(end.equalsIgnoreCase(NO)) {
				return;
			}
			else if(!end.equalsIgnoreCase(YES)) {
//				System.out.println("Invalid command. Try again.");
			}
		}
	}
	
	
	public String getServiceInput() {
		System.out.println("> To add new budget record enter: add");
		System.out.println("> To view all budgets: all");
		System.out.println("> To view event budget details enter: budget");
		System.out.println("> To update budget record enter: update");
		System.out.println("> To delete budget record enter: delete");
		System.out.println("> To exit enter: exit");
		System.out.print("> ");
		String tempInput = sc.nextLine();
		System.out.println();
		
		return tempInput;
	}
	
	public void addBudget(EventService eventService, BudgetService budgetService) {
		System.out.print("Event ID: ");
		id = sc.nextLine();
		if(eventService.checkEvent(id)) {
			System.out.print("Estimated cost for venue: ");
			venue = sc.nextDouble();
			System.out.print("Estimated cost for decorations: ");
			deco = sc.nextDouble();
			System.out.print("Estimated cost for food and beverages: ");
			foodBeverages = sc.nextDouble();
			System.out.print("Estimated cost for awards: ");
			awards = sc.nextDouble();
			System.out.print("Estimated other costs: ");
			other = sc.nextDouble();
			System.out.println();
			
			budgetService.addBudget(id, venue, deco, foodBeverages, awards, other);
		}
		else {
			System.out.println("No such event with event ID: " + id);
		}
	}
	
	public void getAllBudgets(BudgetService budgetService) {
		List<Budget> budgets = budgetService.getAllBudgets();
		
	    System.out.println("Budget List: "); 		
	    for (Budget budget : budgets) {
	    	System.out.println();
	    	System.out.println("Event ID: " + budget.getEventId());
	        System.out.println("Venue cost: " + budget.getVenueCost());
	        System.out.println("Decorations cost: " + budget.getDecoCost());
	        System.out.println("Food and Beverages cost: " + budget.getFoodBeveragesCost());
	        System.out.println("Awards cost: " + budget.getAwardsCost());
	        System.out.println("Other costs: " + budget.getOtherCost());
	        System.out.println("Grand total: " + budget.getTotal());
	        System.out.println();
	    }
	}
	
	public void getBudget(BudgetService budgetService) {
		String tempId;
		System.out.print("Enter event ID: ");
		tempId = sc.nextLine();
		Budget budget = budgetService.getBudget(tempId);
		if(budget != null) {
	    	System.out.println();
	    	System.out.println("Event ID: " + budget.getEventId());
	        System.out.println("Venue cost: " + budget.getVenueCost());
	        System.out.println("Decorations cost: " + budget.getDecoCost());
	        System.out.println("Food and Beverages cost: " + budget.getFoodBeveragesCost());
	        System.out.println("Awards cost: " + budget.getAwardsCost());
	        System.out.println("Other costs: " + budget.getOtherCost());
	        System.out.println("Grand total: " + budget.getTotal());
	        System.out.println();
		}
	}
	
	public void updateBudget(BudgetService budgetService) {
		String tempId;
		System.out.print("Enter event ID where you want to update: ");
		tempId = sc.nextLine();
		Budget budget = budgetService.getBudget(tempId);
		if(budget != null) {
			System.out.println("Existing budget details,");
	    	System.out.println("Event ID: " + budget.getEventId());
	        System.out.println("Venue cost: " + budget.getVenueCost());
	        System.out.println("Decorations cost: " + budget.getDecoCost());
	        System.out.println("Food and Beverages cost: " + budget.getFoodBeveragesCost());
	        System.out.println("Awards cost: " + budget.getAwardsCost());
	        System.out.println("Other costs: " + budget.getOtherCost());
	        System.out.println("Grand total: " + budget.getTotal());
	        System.out.println();
			
			System.out.println("Event ID: " + budget.getEventId());
			System.out.print("New estimated cost for venue: ");
			venue = sc.nextDouble();
			System.out.print("New estimated cost for decorations: ");
			deco = sc.nextDouble();
			System.out.print("New estimated cost for food and beverages: ");
			foodBeverages = sc.nextDouble();
			System.out.print("New estimated cost for awards: ");
			awards = sc.nextDouble();
			System.out.print("New estimated other costs: ");
			other = sc.nextDouble();
			System.out.println();
			
			total = venue + deco + foodBeverages + awards + other;
			Budget newBudget = new Budget(tempId, venue, deco, foodBeverages, awards, other, total);
			budgetService.updateBudget(tempId, newBudget);
		}
	}
	
	public void deleteBudget(BudgetService budgetService) {
		String tempId;
		System.out.print("Enter event ID where you want to delete: ");
		tempId = sc.nextLine();
		budgetService.deleteBudget(tempId);
	}
	

}
