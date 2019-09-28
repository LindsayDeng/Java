package company;

import java.util.Calendar; // Note: OurDate wraps Calendar

/**
 * Class OurDate: to process dates
 * Assignment Title: COMPANY MANAGEMENT TOOL PROTOTYPE
 * Due Date: March 31, 2019
 * @author Mingzhen Deng
 * 
 */

public class OurDate {

	
	private int day;
	private int month;
	private int year;
	private static final Calendar CALENDAR = Calendar.getInstance();

	/**
	 * no-arg constructor for dates
	 */
	public OurDate() {
		this(CALENDAR.get(Calendar.DATE), CALENDAR.get(Calendar.MONTH + 1), CALENDAR.get(Calendar.YEAR));
	}

	/**
	 * constructor to modify day, month and year
	 * @param day 
	 * @param month
	 * @param year 
	 */
	
	public OurDate(int day, int month, int year) {
		setDay(day);
		setMonth(month);
		setYear(year);
	}
	/**
	 * modify day
	 * @param day 
	 */
	private void setDay(int day) {
		this.day = day;
	}

	/**
	 * modify month
	 * @param month
	 */
	private void setMonth(int month) {
		this.month = month;
	}

	/**
	 * modify year
	 * @param year
	 */
	private void setYear(int year) {
		this.year = year;
	}

	/**
	 * obtain day
	 * @return day
	 */
	public int getDay() {
		return day;
	}

	/**
	 * obtain month
	 * @return month
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * obtain year
	 * @return year
	 */
	public int getYear() {
		return year;
	}
	
	/**
	 *  change output format to day/month/year
	 */
	@Override
	public String toString() {
		return this.day + "/" + this.month + "/" + this.year;
	}
	/**
	 * compare two dates for equality
	 */
	@Override
	public boolean equals(Object obj) {

		if ((obj == null) || (this.getClass() != obj.getClass()))
			return false;
		OurDate other = (OurDate) obj;
		return (this.getDay() == other.getDay() && this.getMonth() == other.getMonth()
				&& this.getYear() == other.getYear());

	}// END EQUALS METHOD

}// END CLASS EMPLOYEE
