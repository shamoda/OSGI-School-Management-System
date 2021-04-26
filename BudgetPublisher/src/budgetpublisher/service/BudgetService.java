package budgetpublisher.service;

import java.util.List;

import budgetpublisher.model.Budget;


public interface BudgetService {
	
	public void addBudget(String id, double venue, double deco, double food, double award, double other);
	
	public List<Budget> getAllBudgets();
	
	public Budget getBudget(String id);
	
	public void deleteBudget(String id);
	
	public void updateBudget(String id, Budget budget);

}
