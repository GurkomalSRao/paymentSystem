package Deductions;

public class Deductions {

	private Taxes taxes;						//federal & provincial taxes
	private double pensionFundContribution;
	private double employerContribution;		
	private double employeeContribution;		
	private static final double EI_RATE_EMPLOYEE = .0198;
	private static final double EI_RATE_EMPLOYER = .0277;
	private static final double PENSION_RATE = .0495;
	public Deductions(double grossSalary) {
		super();
		setEmployerInsuranceContribution(grossSalary);
		setEmployeeInsuranceContribution(grossSalary);
		setPensionFundContribution(grossSalary);
		this.taxes = new Taxes(grossSalary);
	}
	public double getEmployerInsuranceContribution() {
		return employerContribution;
	}
	public double getEmployeeInsuranceContribution() {
		return employeeContribution;
	}
	public double getTotalEmployeeContributions() {
		return getPensionFundContribution() + getEmployeeInsuranceContribution();
	}
	
	public double getTotalEmployerContributions() {
		return getPensionFundContribution() + getEmployerInsuranceContribution() ;
	}
	public double getPensionFundContribution() {
		return pensionFundContribution;
	}
	public void setPensionFundContribution(double grossSalary) {
		this.pensionFundContribution = grossSalary * PENSION_RATE;
	}
	
	public void setEmployeeInsuranceContribution(double grossSalary) {
		this.employeeContribution = EI_RATE_EMPLOYEE * grossSalary;
	}

	public void setEmployerInsuranceContribution(double grossSalary) {
		this.employerContribution = EI_RATE_EMPLOYER * grossSalary;
	}
	
	public void print() {
		System.out.println("Federal Tax: " + taxes.getFederalTax() * 100 +"%");
		System.out.println("Provincial Tax: " + taxes.getProvincialTax()* 100 +"%");
		System.out.println("Pension Fund of Canada (Employee): " + getPensionFundContribution());
		System.out.println("Pension Fund of Canada(Employee & Employer): " + getPensionFundContribution() * 2);
		System.out.println("Employment Insurance (Employee): " + getEmployeeInsuranceContribution());
		System.out.println("Employment Insurance (Employee & Employer): " + (getEmployeeInsuranceContribution() + getEmployerInsuranceContribution()));
		
		
	}
}
