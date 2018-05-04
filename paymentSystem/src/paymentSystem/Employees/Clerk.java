package paymentSystem.Employees;

public class Clerk extends AbstractEmployee{

	private double salary;
	private double hoursWorked;
	private static final double CLERK_SALARY = 15.75;
	private static final double OVER_TIME = 44.00;
	
	/*TODO
	 *  receive vacation pay on July 1st
	 *  no pay when sick
	 */
	
	public Clerk(String empNumber, String name, String province, double salary, double hoursWorked) {
		super(empNumber, name, "Clerk");
		this.salary = salary;
		this.hoursWorked = hoursWorked;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	@Override
	public double netSalary() {
		return getHoursWorked() * CLERK_SALARY;
	}

	public double getHoursWorked() {
		return hoursWorked;
	}

	public void setHoursWorked(double hoursWorked) {
		this.hoursWorked = hoursWorked;
	}

	@Override
	public double grossSalary() {
		if(getHoursWorked() < OVER_TIME) {	//no overtime
			return getHoursWorked() * CLERK_SALARY;
		}else {								//overtime pay
			return (getHoursWorked() * CLERK_SALARY) + ((getHoursWorked() - OVER_TIME) * 1.5);
		}
	}

}
