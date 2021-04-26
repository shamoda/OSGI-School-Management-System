package budgetpublisher.service;

import java.util.ArrayList;
import java.util.List;

import budgetpublisher.model.Budget;
import eventpublisher.model.Event;
import eventpublisher.service.EventService;
import eventpublisher.service.EventServiceImpl;

public class BudgetServiceImpl implements BudgetService {
	
	public List<Budget> budgets = new ArrayList<Budget>();
	EventService eventService = new EventServiceImpl();

	@Override
	public void addBudget(String id, double venue, double deco, double food, double award, double other) {
			double total = venue + deco + food + award + other;
			Budget budget = new Budget(id, venue, deco, food, award, other, total);
			budgets.add(budget);
			System.out.println("New record added successfully.");
			System.out.println();
	}

	@Override
	public List<Budget> getAllBudgets() {
		return budgets;
	}

	@Override
	public Budget getBudget(String id) {
		Budget budget = null;
	    for (Budget tempBudget : budgets) { 		      
	    	if(tempBudget.getEventId().equalsIgnoreCase(id)) {
	    		budget = tempBudget;
	    	}
	    }
	    
	    if(budget == null) {
	    	System.out.println("Sorry there is no such record");
    		System.out.println();
	    	return null;
	    }
	    
	    return budget;
	}

	@Override
	public void deleteBudget(String id) {
	    for (Budget tempBudget : budgets) { 		      
	    	if(tempBudget.getEventId().equalsIgnoreCase(id)) {
	    		System.out.println();
	    		System.out.println(tempBudget.getEventId() + " record deleted successfully.");
	    		System.out.println();
	    		budgets.remove(tempBudget);
	    		return;
	    	}
	    }
	    System.out.println("Sorry!!! There is no such record to delete");
	    System.out.println();
	}

	@Override
	public void updateBudget(String id, Budget budget) {
	    for (Budget tempBudget : budgets) { 		      
	    	if(tempBudget.getEventId().equalsIgnoreCase(id)) {
	    		budgets.remove(tempBudget);
	    		budgets.add(budget);
	    		System.out.println(budget.getEventId() + " record updated successfully");
	    		return;
	    	}
	    }
	    System.out.println("Sorry!!! There is no such record to update");
	}

}
