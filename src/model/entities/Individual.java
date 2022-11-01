package model.entities;

public class Individual extends Tax {
	
	private Double healthExpenditures;
	
	public Individual(String name, Double annualIncome, Double healthExpenditures) {
		super(name, annualIncome);
		this.healthExpenditures = healthExpenditures;
	}

	public Double getHealthExpenditures() {
		return healthExpenditures;
	}

	public void setHealthExpenditures(Double healthExpenditures) {
		this.healthExpenditures = healthExpenditures;
	}

	@Override
	public Double taxPayer() {
		double amount = 0.0;
		if(getAnnualIncome() < 20000.00) {
			amount += (getAnnualIncome() * 15 / 100) - (healthExpenditures * 50 / 100);                        
		}
		else if(getAnnualIncome() > 20000.00) {
			amount += (getAnnualIncome() * 25 / 100) - (healthExpenditures * 50 / 100);                        
		} 
		return amount;
	}
}