package paymentSystem.Employees;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;   

public abstract class AbstractEmployee {
	private String empNumber;
	private String name;
	private String department;

	public AbstractEmployee(String empNumber, String name, String department) {
		super();
		this.empNumber = empNumber;
		this.name = name;
		this.department = department;
	}
	public String getEmpNumber() {
		return empNumber;
	}
	public void setEmpNumber(String empNumber) {
		this.empNumber = empNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public abstract double netSalary();
	public abstract double grossSalary();
	public void print() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
		LocalDateTime now = LocalDateTime.now();  
		System.out.println("Current Date: " + dtf.format(now));
	}
}
