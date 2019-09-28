package company;

import java.util.Scanner;

/**
 * Class Staff: to handle staff info
 * Assignment Title: COMPANY MANAGEMENT TOOL PROTOTYPE
 * Due Date: March 31, 2019
 * @author Mingzhen Deng
 * @see Employee.java
 */
public class Staff extends Employee {
	private String department;
	/**
	 * No-arg constructor for staff
	 */
	public Staff() {
		this("unknown", -9, new OurDate(), -1, "unknown");
	}
	/**
	 * set up employee information
	 * @param name employee name
	 * @param employeeNumber employee number
	 * @param startDate start date of contract
	 * @param salary employee salary
	 * @param department employee department
	 */
	public Staff(String name, int employeeNumber, OurDate startDate, double salary, String department) {
		setName(name); // set name, employee number, start date, salary from super class
		setEmployeeNumber(employeeNumber);
		setStartDate(startDate);
		setSalary(salary);
		setDepartment(department); // set department in staff sub class
	}
	/**
	 * obtain employee department
	 * @return department employee department
	 */
	public String getDepartment() { 
		return department;
	}
	/**
	 *  modify employee department 
	 * @param department employee department
	 */
	public void setDepartment(String department) { 
		this.department = department;
	}

	/**
	 * prompt user for department info
	 */
	@Override
	public void loadExtraInfo() { 
		Scanner in = new Scanner(System.in);
		System.out.print("Enter department: ");
		department = in.nextLine();

	}
	/**
	 * overriding superclass toString method to format 
	 * @see company.Employee#toString()
	 */
	@Override
	public String toString() { //
		return getName() + "\t\t" + getEmployeeNumber() + "\t\t" + getStartDate() + "\t" + getSalary() + "\t\t"
				+ "Department: " + getDepartment();
	}
	/**
	 * overriding superclass equals method to compare departments 
	 */
	@Override
	public boolean equals(Object obj) { 
		if ((obj == null) || (this.getClass() != obj.getClass()))
			return false;

		Staff other = (Staff) obj;
		return (super.equals(other) && this.getDepartment().equals(other.getDepartment()));
		// use equals method from parent class
	}// END EQUALS METHOD

}
