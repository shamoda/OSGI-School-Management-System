package budgetpublisher.model;

public class Budget {
	
	String eventId;
	double venueCost;
	double decoCost;
	double foodBeveragesCost;
	double awardsCost;
	double otherCost;
	double total;
	
	public Budget() {
		super();
	}

	public Budget(String eventId, double venueCost, double decoCost, double foodBeveragesCost, double awardsCost,
			double otherCost, double total) {
		super();
		this.eventId = eventId;
		this.venueCost = venueCost;
		this.decoCost = decoCost;
		this.foodBeveragesCost = foodBeveragesCost;
		this.awardsCost = awardsCost;
		this.otherCost = otherCost;
		this.total = total;
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public double getVenueCost() {
		return venueCost;
	}

	public void setVenueCost(double venueCost) {
		this.venueCost = venueCost;
	}

	public double getDecoCost() {
		return decoCost;
	}

	public void setDecoCost(double decoCost) {
		this.decoCost = decoCost;
	}

	public double getFoodBeveragesCost() {
		return foodBeveragesCost;
	}

	public void setFoodBeveragesCost(double foodBeveragesCost) {
		this.foodBeveragesCost = foodBeveragesCost;
	}

	public double getAwardsCost() {
		return awardsCost;
	}

	public void setAwardsCost(double awardsCost) {
		this.awardsCost = awardsCost;
	}

	public double getOtherCost() {
		return otherCost;
	}

	public void setOtherCost(double otherCost) {
		this.otherCost = otherCost;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

}
