package model.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Company;
import model.entities.Individual;
import model.entities.Tax;

public class Program3 {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Tax> tax = new ArrayList<>();
		
		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();
		
		for(int i = 1; i <= n; i++) {
			System.out.println("Tax payer #" + i + " data:");
			System.out.print("Individual or company (i/c)? ");
			char a = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Annual income: ");
			double annualIncome = sc.nextDouble();
			
			if(a == 'i') {
				System.out.print("Health expenditures: ");
				double healthExpenditures = sc.nextDouble();
				
				tax.add(new Individual(name, annualIncome, healthExpenditures));
			}
			else if(a == 'c') {
				System.out.print("Number of employees: ");
				int numberOfEmployees = sc.nextInt();
				
				tax.add(new Company(name, annualIncome, numberOfEmployees));
			}
		}
		
		double total = 0.0;
		System.out.println("TAXES PAID:");
		for(Tax list : tax) { 
			System.out.println(list.getName() + ": $ " + String.format("%.2f", list.taxPayer()));
			total += list.taxPayer();
		}
		
		System.out.println("\nTOTAL TAXES: $ " + String.format("%.2f", total));
		
		sc.close();
	}
}
