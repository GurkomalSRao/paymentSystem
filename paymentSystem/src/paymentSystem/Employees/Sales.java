package paymentSystem.Employees;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import Deductions.Deductions;

public class Sales extends AbstractEmployee{

	private double commRate;
	private double hoursWorked;
	private double monthlySales;
	private double totalSalary;
	private int payPeriod;
	private List<String> payDates;
	private Deductions deductions;
	private static final double SALES_SALARY = 15.00;
	
	public Sales(String empNumber, String name, List<Double> hoursWorked, List<Double> monthlySales, int payPeriod) {
		super(empNumber, name, "Sales");	//passes to employee constructor
		this.hoursWorked = hoursWorked;
		this.monthlySales = monthlySales;
		this.payPeriod = payPeriod;
		this.payDates = new ArrayList<>();
		calculateCommission(monthlySales);
		datesOfPayments();
		deductions = new Deductions(this.grossSalary());
	}

	public double getCommRate() {
		return commRate;
	}

	public void calculateCommission(double sales) {
		if(sales > 2500.00 && sales < 4250.00)
			this.commRate = .015; //1.5%
		else if(sales > 4250.00 && sales < 7000.00)
			this.commRate = .025; //2.5%
		else if(sales > 7000.00)
			this.commRate = .050; //5%
		else
			this.commRate = 0;
	}

	public double getMonthlySales() {
		return monthlySales;
	}

	public void setMonthlySales(double sales) {
		this.monthlySales = sales;
	}

	public double getHoursWorked() {
		return hoursWorked;
	}

	public void setHoursWorked(double hoursWorked) {
		this.hoursWorked = hoursWorked;
	}
	
	public double getTotalSalary() {
		return totalSalary;
	}

	public int getPayPeriod() {
		return payPeriod;
	}

	public void setPayPeriod(int payPeriod) {
		this.payPeriod = payPeriod;
	}

	public void datesOfPayments() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		int monthVal = 1;
		Calendar cal = Calendar.getInstance();
		cal.set( 2018, monthVal, 1 );
		cal.add( Calendar.DAY_OF_MONTH, -( cal.get( Calendar.DAY_OF_WEEK ) % 7 + 1 ) );
		Calendar cal2 = Calendar.getInstance();
		for(int i = 0; i < getPayPeriod(); i ++) {
			cal2.set(Calendar.WEEK_OF_YEAR, i+1);        
			cal2.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
			
			if(sdf.format(cal.getTime()).equals(sdf.format(cal2.getTime()))) {
				this.payDates.add("Payed " 
						+ grossSalary()
						+" on "+ cal.getTime());
				monthVal += 1;
				cal.set( 2018, monthVal, 1 );
				cal.add( Calendar.DAY_OF_MONTH, -( cal.get( Calendar.DAY_OF_WEEK ) % 7 + 1 ) );
			}
		}
	}
	
	@Override
	public double netSalary() {
		return (grossSalary() - deductions.getTotalEmployeeContributions());
	}
	
	@Override
	public double grossSalary() {
		return (getHoursWorked() * SALES_SALARY) + (getCommRate() * getMonthlySales());
	}
	
	@Override
	public void print() {
		super.print();
		System.out.println("Date & Week # (Pay Period): ");
		for(String pay : this.payDates) {
			System.out.println(pay);
		}
		System.out.println("Employee Number: " + getEmpNumber());
		System.out.println("Employee Name: " + getName());
		System.out.println("Department: " + getDepartment());
		System.out.println("Gross Salary: " + grossSalary());
		System.out.println("Net Salary: " + netSalary());
		deductions.print();
	}

}
