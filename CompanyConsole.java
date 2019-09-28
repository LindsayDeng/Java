package company;

import java.util.Scanner;

/**
 * Class CompanyConsole: launches program 
 * Assignment Title: COMPANY MANAGEMENT TOOL PROTOTYPE
 * Due Date: March 31, 2019
 * @author Mingzhen Deng
 */

public class CompanyConsole {

	
	private static final int ADDEMPLOYEE = 1;
	private static final int DISPLAYEMPLOYEES = 2;
	private static final int DISPLAYSENIOREMPLOYEE = 3;
	private static final int FINDEMPLOYEE = 4;
	private static final int DELETEEMPLOYEE = 5;
	private static final int EXIT = 9;
	public static final int MANAGER = 1;
	public static final int STAFF = 2;
	public static final int TEMP = 3;

	private Company startUp;

	private Scanner in = new Scanner(System.in);
	/**
	 * no-arg constructor for company console
	 */
	public CompanyConsole() {
		startUp = new Company();
	}

	/**
	 * starting point of the program
	 * runs menu for user input
	 * @param args
	 */
	public static void main(String[] args) {
		CompanyConsole console = new CompanyConsole();
		console.menu();
	}

	/**
	 * menu for user interface
	 * user's choice determines execution 
	 */
	
	public void menu() {
		int choice;
		do {

			System.out.println("\n********************************************************");
			System.out.println(CompanyConsole.ADDEMPLOYEE + ".  ADD EMPLOYEE");
			System.out.println(CompanyConsole.DISPLAYEMPLOYEES + ".  DISPLAY EMPLOYEES");
			System.out.println(CompanyConsole.DISPLAYSENIOREMPLOYEE + ".  DISPLAY SENIOR EMPLOYEE");
			System.out.println(CompanyConsole.FINDEMPLOYEE + ".  FIND EMPLOYEE ");
			System.out.println(CompanyConsole.DELETEEMPLOYEE + ".  DELETE EMPLOYEE ");
			System.out.println(CompanyConsole.EXIT + ".  EXIT ");
			System.out.println("*******************************************************\n");

			System.out.print("SELECTION: ");

			choice = in.nextInt();
			in.nextLine(); // get rid of newline character in buffer

			switch (choice) {
			case CompanyConsole.ADDEMPLOYEE:
				addEmployee();
				break;
			case CompanyConsole.DISPLAYEMPLOYEES:
				displayEmployees();
				break;
			case CompanyConsole.DISPLAYSENIOREMPLOYEE:
				displaySeniorEmployee();
				break;
			case CompanyConsole.FINDEMPLOYEE:
				findEmployee();
				break;
			case CompanyConsole.DELETEEMPLOYEE:
				deleteEmployee();
				break;
			case CompanyConsole.EXIT:
				System.out.println("Goodbye");
				break;
			default:
				System.out.println("INVALID CHOICE; PLEASE RE-ENTER");
			}
		} while (choice != CompanyConsole.EXIT); // end do and exit program
	}// end menu

	/**
	 * using findSeniorEmployee method, senior employee info is displayed
	 */
	// outputs senior employee information to the console using findSeniorEmployee
	private void displaySeniorEmployee() {
		if (startUp.currentNumberEmployees() == 0) {
			System.out.println("There are no employees\n");
		} else {
			Employee e = startUp.findSeniorEmployee();
			System.out.println("SENIOR EMPLOYEE:\n" + e.toString());
		}
	}
	/**
	 * display all employee information that is entered
	 */
	private void displayEmployees() {
		System.out.println("NAME\t\t\tEMPLOYEE NO.\tSTART DATE\tSALARY\t\tEMPLOYEE INFO\n");
		for (int i = 0; i < startUp.currentNumberEmployees(); i++)
			if (startUp.getEmployees().get(i) != null)
				System.out.println(startUp.getEmployees().get(i));

	}

	/**
	 * add an employee to the list
	 */
	private void addEmployee() {

		if (startUp.isMaximumEmployees()) // check if space available in array first
			System.out.println("Attempt to exceed maximum Employee array size;\n" + "can't add another employee");
		else { // prompt user to add new employee information

			System.out.println("ENTER NEW EMPLOYEE INFORMATION: ");
			System.out.print("NAME: ");
			String name = in.nextLine();

			System.out.print("EMPLOYEE NUMBER: ");
			int employeeNumber = in.nextInt();

			System.out.println("HIRING DATE");
			System.out.print("YEAR: ");
			int year = in.nextInt();

			System.out.print("MONTH: ");
			int month = in.nextInt();

			System.out.print("DAY: ");
			int day = in.nextInt();

			System.out.print("SALARY: ");
			double salary = in.nextDouble();

			System.out.print("Employee Type (Manager = 1, Staff = 2, Temp = 3): ");
			int empType = in.nextInt();

			if (empType == 1 || empType == 2 || empType == 3) {
				Employee temp = startUp.addEmployee(name, employeeNumber, new OurDate(day, month, year), salary,
						empType);

				temp.loadExtraInfo();
			} else {
				System.out.println("Invalid Employee Type");
			}

		} // end else

	}// END ADDEMPLOYEE()
	/**
	 * find employee with employee work number
	 */
	private void findEmployee() {
		System.out.print("ENTER EMPLOYEE NUMBER: ");
		int employeeNumber = in.nextInt(); // user input

		if (startUp.findEmployee(employeeNumber) != null) { // loop through employee array list if not null
			System.out.print("NAME\t\t\tEMPLOYEE NO.\tSTART DATE\tSALARY\t\tEMPLOYEE INFO\n");
			System.out.println(startUp.findEmployee(employeeNumber)); // print employee if found
		} else {
			System.out.print("An employee with that number could not be found\n"); // print error message if employee
																					// not found
		}

	} // END FINDEMPLOYEE()

	/**
	 * delete employee with employee work number
	 */
	private void deleteEmployee() {
		System.out.print("Enter number of employee to delete:");
		int employeeNumber = in.nextInt();

		if (startUp.findEmployee(employeeNumber) != null) {// loop through employee array list if not null
			Employee temp = startUp.deleteEmployee(employeeNumber);
			System.out.print("The record for " + temp.getName() + ", Employee Number, " + temp.getEmployeeNumber());
			System.out.println(" has been deleted"); // print employee info after deletion

		} else {
			System.out.print("An employee with that number could not be found\n"); // print error message if failed
		}

	}// end deleteEmployee

}// END CLASS COMPANYCONSOLE
