package model.entities;

public class Company extends Tax {
	
	private Integer numberOfEmployees;

	public Company(String name, Double annualIncome, Integer numberOfEmployees) {
		super(name, annualIncome);
		this.numberOfEmployees = numberOfEmployees;
	}
	
	public Integer getNumberOfEmployees() {
		return numberOfEmployees;
	}

	public void setNumberOfEmployees(Integer numberOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
	}

	@Override
	public Double taxPayer() {
		double amount = 0.0;
		if(numberOfEmployees > 10) {
			amount += getAnnualIncome() * 14 / 100;
		}
		else {
			amount += getAnnualIncome() * 16 / 100;	
		}
		return amount;
	}
}