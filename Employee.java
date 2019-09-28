package company;

/**
 * Class Employee: abstracts a Company employee
 * Assignment Title: OMPANY MANAGEMENT TOOL PROTOTYPE
 * Due Date: March 31, 2019
 * @author Mingzhen Deng
 * 
 */
public abstract class Employee {

	private String name; 
	private int employeeNumber; 
	private OurDate startDate; 
	private double salary; 
	/**
	 * no-arg constructor for employee class
	 */

	public Employee() {
		this("unknown", -9, new OurDate(), -1);
	}

	/**
	 * modify employee info 
	 * @param name employee name
	 * @param employeeNumber employee work number
	 * @param startDate start date of contract
	 * @param salary employee salary
	 */
	public Employee(String name, int employeeNumber, OurDate startDate, double salary) {
		setName(name);
		setEmployeeNumber(employeeNumber);
		setStartDate(startDate);
		setSalary(salary);
	}
	/**
	 * obtian employee name
	 * @return name employee name
	 */
	public String getName() {
		return name;
	}

	/**
	 * obtain employee work number
	 * @return employee work number
	 */
	public int getEmployeeNumber() {
		return employeeNumber;
	}

	/**
	 * obtain employee contract start date
	 * @return startDate employee contract start date
	 */
	// return's the Employee's starting date, as an OurDate object
	public OurDate getStartDate() {
		return startDate;
	}

	/**
	 * obtain employee salary
	 * @return salary employee salary
	 */
	public double getSalary() {
		return salary;
	}

	/**
	 * modify employee name
	 * @param name employee name
	 */
	protected void setName(String name) {
		this.name = name;
	}
	/**
	 * modify employee work number
	 * @param employeeNumber employee work number
	 */
	protected void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}
	/**
	 * modify start date of contract
	 * @param startDate start date of contract
	 */
	protected void setStartDate(OurDate startDate) {
		this.startDate = startDate;
	}
	/**
	 * modify employee salary
	 * @param salary employee salary
	 */
	protected void setSalary(double salary) {
		this.salary = salary;
	}

	/**
	 * modify output format
	 */
	@Override
	public String toString() {
		return getName() + "\t\t" + getEmployeeNumber() + "\t\t" + getStartDate() + "\t" + getSalary();
	}
	/**
	 * compare two employee objects
	 */
	@Override
	public boolean equals(Object obj) {
		if ((obj == null) || (this.getClass() != obj.getClass()))
			return false;
		Employee other = (Employee) obj;
		return (this.getName().equals(other.getName()) && this.getEmployeeNumber() == other.getEmployeeNumber()
				&& this.getStartDate().equals(other.getStartDate()));

	}// END EQUALS METHOD

	public abstract void loadExtraInfo();

}// END CLASS EMPLOYEE
