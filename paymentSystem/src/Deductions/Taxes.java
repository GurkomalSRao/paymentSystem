package Deductions;

import java.util.HashMap;
import java.util.Map;

public class Taxes {
	
	private double federalTax;
	private double provincialTax;
	private Map<String, Double> provincialTaxesList;
	private static final double FEDERAL_BASE_VALUE = 35000.00;
	private double totalTaxPayment;
	
	public Taxes(double annualSalary) {
		super();
		provincialTaxesList = new HashMap<String, Double>();
		setFederalTax(annualSalary);
		setProvincialTax(annualSalary);
		setTotalTaxPayment(calculateDeductions(annualSalary));
	}
	public double getFederalTax() {
		return federalTax;
	}
	public void setFederalTax(double annualSalary) {
		if(annualSalary <= FEDERAL_BASE_VALUE)	//first 35,000$
			this.federalTax = .1600;
		else if (annualSalary >= FEDERAL_BASE_VALUE * 2) //second 35,000 or greater
			this.federalTax = .2200;
	}
	public double getProvincialTax() {
		return provincialTax;
	}
	public void setProvincialTax(double annualSalary) {		
		if(annualSalary < 42705)
			this.provincialTax = .15;
		else if(annualSalary > 42705 && annualSalary < 85405)
			this.provincialTax = .20;
		else if(annualSalary > 85405 && annualSalary < 103915)
			this.provincialTax = .24;
		else if(annualSalary > 103915)
			this.provincialTax = .2575;
		
	}
	
	private double calculateDeductions(double annualSalary) {
		return (annualSalary * getFederalTax()) + (annualSalary * getProvincialTax());
	}

	public double getTotalTaxPayment() {
		return totalTaxPayment;
	}
	public void setTotalTaxPayment(double totalTaxPayment) {
		this.totalTaxPayment = totalTaxPayment;
	}
	
}
