/**
 * Class Company: abstracts a company
 * @author Carolyn MacIsaac, with modifications by Dave Houtman
 * CST8284
 * Assignment 1: Company Management Tool prototype
 * February 11 2019
 */
package company;
import java.util.ArrayList;

/**
 * Class Company: to add, find, delete an employee
 * Assignment Title: COMPANY MANAGEMENT TOOL PROTOTYPE
 * Due Date: March 31, 2019
 * @author Mingzhen Deng
 *
 */

public class Company {

	private ArrayList<Employee> employees = new ArrayList<>(); // declare array list

	/**
	 * no-arg constructor with some employees added initially
	 */
	public Company() {
		addEmployee("Alvin Spring", 14, new OurDate(2, 12, 2014), 15000, 3);
		addEmployee("Grant Barge", 21, new OurDate(18, 5, 2009), 40000, 2);
		addEmployee("Ross Chuttle", 23, new OurDate(22, 2, 2010), 43269, 1);
		// instantiate array list
	}
	/**
	 * add an employee 
	 * @param name
	 * @param employeeNumber
	 * @param date
	 * @param salary
	 * @param empType
	 * @return employee info 
	 */
	public Employee addEmployee(String name, int employeeNumber, OurDate date, double salary, int empType) {
		// use switch to determine which type of employee to add
		switch (empType) {
		case 1:
			employees.add(new Manager(name, employeeNumber, date, salary, "unknown"));
			break;
		case 2:
			employees.add(new Staff(name, employeeNumber, date, salary, "unknown"));
			break;
		case 3:
			employees.add(new Temp(name, employeeNumber, date, salary, new OurDate()));
			break;
		}
		
		return employees.get(employees.size() - 1);

	}
	/**
	 * obtain number of employee entered
	 * @return employee arrayList size 
	 */
	public int currentNumberEmployees() { 
		return employees.size();
	}
	/**
	 * obtain whether max number of employees reached
	 * @return if max employee reached
	 */
	public boolean isMaximumEmployees() { 
		return false;
	}

	/**
	 * obtain current employee arrayList
	 * @return current arrayList
	 */
	public ArrayList<Employee> getEmployees() { 
		return employees;
	}
	/**
	 * delete an employee with employee work number
	 * @param empNum employee work number
	 * @return deleted employee
	 */
	public Employee deleteEmployee(int empNum) { // delete employee

		if (findEmployee(empNum) == null) { // return null if employee cannot be found
			return null;
		} else {

			Employee delEmp = (findEmployee(empNum)); // copy the employee to be deleted
			employees.remove(findEmployee(empNum)); // execute delete employee

			return delEmp; // return copied employee
		}

	}
	/**
	 * find employee with work number
	 * @param empNum find an employee with employee work number
	 * @return return employee object
	 */
	public Employee findEmployee(int empNum) {

		for (Employee emp : employees) { // loop through the array list to find employee with given employee number
			if (empNum == emp.getEmployeeNumber()) {
				return emp; // return employee object
			} // end if
		} // end for loop

		return null; // return null if not found

	}
	/**
	 * obtain employee with the longest employment 
	 * @return senior employee
	 */
	public Employee findSeniorEmployee() {
		if (currentNumberEmployees() == 0) { // if no employees inserted return null
			return null;
		}

		OurDate currentDate = new OurDate();
		int currentYear = currentDate.getYear(); // current year
		int currentMonth = currentDate.getMonth(); // current month
		int currentDay = currentDate.getDay(); // current day
		int max = 0;

		for (int i = 0; i < currentNumberEmployees(); i++) {
			if (getEmployees().get(i) != null) { // // if employee is found
				if (currentYear > getEmployees().get(i).getStartDate().getYear()) { // compare year
					currentYear = getEmployees().get(i).getStartDate().getYear(); // set to senior employee year
					currentMonth = getEmployees().get(i).getStartDate().getMonth(); // set to senior employee month
					currentDay = getEmployees().get(i).getStartDate().getDay(); // set to senior employee day
					max = i; // get senior employee index number
				}

				else if (currentYear == getEmployees().get(i).getStartDate().getYear()) { // compare month if year is
																							// same

					if (currentMonth > getEmployees().get(i).getStartDate().getMonth()) { // compare month
						currentMonth = getEmployees().get(i).getStartDate().getMonth(); // set to senior employee month
						currentDay = getEmployees().get(i).getStartDate().getDay(); // set to senior employee day
						max = i; // get senior employee index number
					} else if (currentMonth == getEmployees().get(i).getStartDate().getMonth()) { // compare day if
																									// month and year is
																									// same

						if (currentDay > getEmployees().get(i).getStartDate().getDay()) { // compare day
							currentDay = getEmployees().get(i).getStartDate().getDay(); // set to senior employee day
							max = i; // get senior employee index number

						} // end if
					} // end else if
				} // end else if
			} // end if
		} // end for loop

		return employees.get(max); // return senior employee with index number

	}

}// end class
