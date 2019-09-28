package testcompany;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import company.Company;
import company.Employee;
import company.Manager;
import company.OurDate;
import company.Temp;

/**
 * JUNIT test file
 * Assignment Title: ASSIGNMENT 2, COMPANY MANAGEMENT TOOL PROTOTYPE PART 2
 * Due Date: March 31, 2019
 * @author Mingzhen Deng
 *
 */

class TestEmployee {

	Employee e1;
	Employee e2;
	Company s1;
	OurDate date;
	Calendar CAL = Calendar.getInstance();

	@BeforeAll
	static void setUpBeforeAllTests() {
		System.out.println("STARTING TESTING....");
	}

	@AfterAll
	static void tearDownAfterAllTests() {
		System.out.println("ENDING TESTING....");
	}

	@BeforeEach
	void setUpBeforeEachTest() {
		System.out.println("Starting test....");
	}

	@AfterEach
	void tearDownAfterEachTest() {
		System.out.println("Ending test....");
		;
	}

	@Test
	void testEmployeeEquals() {
		// instantiate two manager employees and test if they are equal
		e1 = new Manager("Joe Smith", 44, new OurDate(5, 9, 1987), 55000, "Supervisor");
		e2 = new Manager("Joe Smith", 44, new OurDate(5, 9, 1987), 55000, "Supervisor");
		assertTrue(e1.equals(e2));
		e1 = null;
		e2 = null;
	}

	@Test
	void testEmployeeNotEquals() {
		// instantiate two manager employees with different number and test if they are
		// not equal
		e1 = new Manager("Joe Smith", 44, new OurDate(5, 9, 1987), 55000, "Supervisor");
		e2 = new Manager("Joe Smitk", 43, new OurDate(5, 9, 1987), 55000, "Supervisor");

		assertFalse(e1.equals(e2));

		e1 = null;
		e2 = null;
	}

	@Test
	void testDeleteEmployeeReturnsNull() {
		// test if deleting a non-existent employee number would return null
		s1 = new Company();
		assertNull(s1.deleteEmployee(5));
		s1 = null;

	}

	@Test
	void testDeletesFirstEmployeeOnly() { // test if deleting the first employee if employee number is repeated
		s1 = new Company();

		s1.addEmployee("Joe Smith", 44, new OurDate(5, 9, 1987), 55000, 1);
		s1.addEmployee("Mary Johnson", 44, new OurDate(5, 9, 1987), 55000, 2);
		s1.deleteEmployee(44);

		assertNotEquals("Joe Smith", s1.findEmployee(44).getName());
		assertEquals("Mary Johnson", s1.findEmployee(44).getName());

		s1 = null;
	}

	@Test
	void testNoAccidentalDeleteEmployee() { // check if an employee is accidentally deleted with invalid employee number
		s1 = new Company();
		s1.addEmployee("Joe Smith", 44, new OurDate(5, 9, 1987), 55000, 1);
		s1.deleteEmployee(5);
		assertEquals(4, s1.currentNumberEmployees());
		s1 = null;
	}

	void testTempEquals() { // test if two temp employees are the same employee
		e1 = new Temp("Joe Smith", 44, new OurDate(5, 9, 1987), 55000, new OurDate(3, 3, 2020));
		e2 = new Temp("Joe Smitk", 43, new OurDate(5, 9, 1987), 55000, new OurDate(3, 3, 2020));
		assertTrue(e1.equals(e2));
		e1 = null;
		e2 = null;
	}

	@Test
	public void testDefaultOurDateConstructor() { // test default constructor
		date = new OurDate(CAL.get(Calendar.DATE), CAL.get(Calendar.MONTH + 1), CAL.get(Calendar.YEAR));
		assertEquals(date.getDay(), CAL.get(Calendar.DATE));
		assertEquals(date.getMonth(), CAL.get(Calendar.MONTH + 1));
		assertEquals(date.getYear(), CAL.get(Calendar.YEAR));

		date = null;
	}

	@Test
	public void testOverloadedOurDateConstructor() { // test overloaded constructor
		date = new OurDate(CAL.get(Calendar.DATE), CAL.get(Calendar.MONTH + 1), CAL.get(Calendar.YEAR));
		assertEquals(date.getDay(), CAL.get(Calendar.DATE));
		assertEquals(date.getMonth(), CAL.get(Calendar.MONTH + 1));
		assertEquals(date.getYear(), CAL.get(Calendar.YEAR));

		date = null;
	}

}
