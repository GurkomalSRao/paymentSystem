package test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;

import paymentSystem.Employees.AbstractEmployee;
import paymentSystem.Employees.Clerk;
import paymentSystem.Employees.Sales;

class ValidateEmployee {
	
	Sales sale;
	Clerk clerk;
	List<AbstractEmployee> employeeList;

	@Test
	void test() {
		// Employee Number, Name, Hourly Pay, Hours Worked, payPeriod
		sale = new Sales("123", "John", 15, 2650,8);
		//clerk = new Clerk("124", "Allan", "BC", 15.75, 43);
		employeeList = new ArrayList<>();
		employeeList.add(sale);
		employeeList.add(clerk);
		employeeList.get(0).print();		
		//assertEquals(246.402825,employeeList.get(0).netSalary());
		//assertEquals(264.75,employeeList.get(0).grossSalary());
		//assertEquals(225.0,employeeList.get(1).netSalary());
		//assertEquals(677.25,employeeList.get(1).grossSalary());
	}
	
	//@Test
	void calendarTest() {
		//get last friday of every month
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
		int monthVal = 1;
		Calendar cal = Calendar.getInstance();
		cal.set( 2018, monthVal, 1 );
		cal.add( Calendar.DAY_OF_MONTH, -( cal.get( Calendar.DAY_OF_WEEK ) % 7 + 1 ) );
		//System.out.println("Calendar Week:" + cal.get(Calendar.WEEK_OF_YEAR));
		System.out.println("Last Friday of Month: " + sdf.format(cal.getTime()));
		int payPeriod = 13;
		Calendar cal2 = Calendar.getInstance();
		for(int i = 0; i < payPeriod; i ++) {
			cal2.set(Calendar.WEEK_OF_YEAR, i+1);        
			cal2.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
			//System.out.println(sdf.format(cal2.getTime())); 
			System.out.println(monthFormat.format(cal2.getTime()));
			if(sdf.format(cal.getTime()).equals(sdf.format(cal2.getTime()))) {
				//System.out.println("Payed!");
				
				monthVal += 1;
				cal.set( 2018, monthVal, 1 );
				cal.add( Calendar.DAY_OF_MONTH, -( cal.get( Calendar.DAY_OF_WEEK ) % 7 + 1 ) );
			}
			
		}
		/*Date dateOfOrder = new Date();
		int noOfDays = 7;
		int weekVal = 1;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dateOfOrder);            
		calendar.add(Calendar.DAY_OF_YEAR, noOfDays*weekVal);
		calendar.add( Calendar.DAY_OF_MONTH, -( calendar.get( Calendar.DAY_OF_WEEK ) % 7 + 1 ) );*/
		//System.out.println(calendar.getTime());
		//System.out.println("Calendar Week:" + calendar.get(Calendar.WEEK_OF_YEAR));
	}
}
