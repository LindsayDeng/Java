package company;

import java.util.Scanner;

/**
 * Class Temp: to handle temporary employee info 
 * Assignment Title: COMPANY MANAGEMENT TOOL PROTOTYPE
 * Due Date: March 31, 2019
 * @author Mingzhen Deng
 * @see Employee.java
 *
 */
public class Temp extends Employee {
	private OurDate endContractDate;
	
	/**
	 * No-arg constructor for Temp employee
	 * 
	 */
	public Temp() {
		this("unknown", -9, new OurDate(), -1, new OurDate());
	}
	/**
	 * set employee information
	 * @param name employee name
	 * @param employeeNumber employee number
	 * @param startDate start date
	 * @param salary employee salary
	 * @param endContractDate contract end date
	 */
	public Temp(String name, int employeeNumber, OurDate startDate, double salary, OurDate endContractDate) {
		setName(name); 
		setEmployeeNumber(employeeNumber);
		setStartDate(startDate);
		setSalary(salary);
		setEndContractDate(endContractDate); 
	}
	/**
	 * obtain end contract date
	 * @return getEndContractDate last day of contract
	 */
	public OurDate getEndContractDate() { 
		return endContractDate;
	}
	/**
	 * modify end contract date
	 * @param endContractDate last day of contract
	 *
	 */
	public void setEndContractDate(OurDate endContractDate) { 
		this.endContractDate = endContractDate;
	}
	/**
	 * modify end contract date with given date
	 * @param day end contract day
	 * @param month end contract month
	 * @param year end contract year
	 */
	public void setEndContractDate(int day, int month, int year) {
		this.endContractDate = new OurDate(day, month, year);
	}
	/**
	 * prompt user of end date info 
	 */
	@Override
	public void loadExtraInfo() { 
		Scanner in = new Scanner(System.in);
		System.out.println("Enter contract end date: ");
		System.out.print("YEAR: ");
		int year = in.nextInt();

		System.out.print("MONTH: ");
		int month = in.nextInt();

		System.out.print("DAY: ");
		int day = in.nextInt();

		setEndContractDate(new OurDate(day, month, year));

	}
	/**
	 *  overriding superclass toString method to format
	 *  
	 */
	@Override
	public String toString() { 
		return getName() + "\t\t" + getEmployeeNumber() + "\t\t" + getStartDate() + "\t" + getSalary() + "\t\t"
				+ "End of Contract: " + getEndContractDate();
	}
	/**
	 * overriding superclass equals method to compare end contract date
	 */
	@Override
	public boolean equals(Object obj) { 
		if ((obj == null) || (this.getClass() != obj.getClass()))
			return false;

		Temp other = (Temp) obj;
		return (super.equals(other) && this.getEndContractDate().equals(other.getEndContractDate()));
		// use equals method from parent class
	}// END EQUALS METHOD

}
