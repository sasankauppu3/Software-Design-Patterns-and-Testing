package question1tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import hw4.question1.CPhoneNumber;

public class testq1c {

	CPhoneNumber crf = new CPhoneNumber();
	
	@Test
	public void test1() {
		assertEquals("Invalid PhoneNumber: Null",false, crf.validPhoneNumber(""));
	}
	
	@Test
	public void test2() {
		assertEquals("Invalid PhoneNumber: Inavlid chars",false, crf.validPhoneNumber("a123b80-87"));
	}
	
	@Test
	public void test3() {
		assertEquals("Invalid PhoneNumber: Longer than 10 chars",false, crf.validPhoneNumber("987654321987"));
	}
	
	@Test
	public void test4() {
		assertEquals("Invalid PhoneNumber: starts with 1",false, crf.validPhoneNumber("198765432"));
	}
	
	@Test
	public void test5() {
		assertEquals("Invalid PhoneNumber: starts with 0",false, crf.validPhoneNumber("098765432"));
	}
	
	@Test
	public void test6() {
		assertEquals("Invalid PhoneNumber: starts with 555",false, crf.validPhoneNumber("5559876543"));
	}
	
	@Test
	public void test7() {
		assertEquals("Invalid PhoneNumber: starts with +",false, crf.validPhoneNumber("+18573086630"));
	}
	
	@Test
	public void test8() {
		assertEquals("Valid PhoneNumber",true, crf.validPhoneNumber("8573086630"));
	}

	@Test
	public void test9() {
		assertEquals("Invalid PhoneNumber: less than 10 chars",false, crf.validPhoneNumber("73086630"));
	}
	
}

