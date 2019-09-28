package company;
import java.util.Scanner;

/**
 * Class Manager: to handle manager info
 * Assignment Title: COMPANY MANAGEMENT TOOL PROTOTYPE
 * Due Date: March 31, 2019
 * @author Mingzhen Deng
 * @see Employee.java
 */
public class Manager extends Employee {
	private String title;
	/**
	 * no-arg constructor for managers
	 */
	public Manager () {
		 this("unknown", -9, new OurDate(), -1, "unknown");
	}
	/**
	 * set manager information
	 * @param name employee
	 * @param employeeNumber employee number
	 * @param startDate start date of contract
	 * @param salary employee salary
	 * @param title employee job title
	 */
	public Manager (String name, int employeeNumber, OurDate startDate, double salary, String title) {
		setName(name); // set name, employee number, start date, salary from super class
		setEmployeeNumber(employeeNumber);
		setStartDate(startDate);
		setSalary(salary);
		setTitle(title); // set title in sub manager sub class
	}
	
	/**
	 * obtain employee job title
	 * @return title employee job title
	 */
	public String getTitle() { // get title 
		return title;
	}
	/**
	 * modify employee job title
	 * @param title employee job title
	 */
	public void setTitle(String title) { // set title
		this.title = title;
	}
	/**
	 * prompt user to input manager info
	 */
	@Override
	public void loadExtraInfo() { 
		Scanner in = new Scanner(System.in);
		System.out.print("Enter manager's title: ");
		title = in.nextLine();
	}
	
	/**
	 * overriding superclass to string method to format
	 */
	@Override
	public String toString() { 
		return  getName() + "\t\t" + getEmployeeNumber() + "\t\t" + getStartDate() +  "\t" + getSalary() +  "\t\t" 
	+ "Title: " +getTitle();
	}
	/**
	 * overriding superclass equals method to compare managers
	 */
	@Override
	public boolean equals(Object obj) {
		if ((obj == null) || (this.getClass() != obj.getClass())) 
			return false;
		
		Manager other = (Manager) obj;		
		return (super.equals(other) && this.getTitle().equals(other.getTitle()));
		// use equals method from parent class
				
	}//END EQUALS METHOD 

}
