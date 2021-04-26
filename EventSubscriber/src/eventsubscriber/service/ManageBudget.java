package eventsubscriber.service;

import budgetpublisher.service.BudgetService;
import eventpublisher.service.EventService;

public interface ManageBudget {
	
	public void clientBudget(EventService eventService, BudgetService budgetService);
	
	public String getServiceInput();
	
	public void addBudget(EventService eventService, BudgetService budgetService);
	
	public void getAllBudgets(BudgetService budgetService);
	
	public void getBudget(BudgetService budgetService);
	
	public void updateBudget(BudgetService budgetService);
	
	public void deleteBudget(BudgetService budgetService);

}
