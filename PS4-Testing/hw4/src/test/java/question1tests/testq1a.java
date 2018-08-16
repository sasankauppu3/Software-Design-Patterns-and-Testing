package question1tests;

import static org.junit.Assert.*;
import hw4.question1.*;
import org.junit.Test;

public class testq1a {

	@Test
	public void test1() {
		ARangeInt temp = new ARangeInt();
		assertEquals("Large negative Int testing: not in range",false, temp.intRange(-99999));
	}
	
	@Test
	public void test2() {
		ARangeInt temp = new ARangeInt();
		assertEquals("Boundary outside negative Int testing: not in range",false, temp.intRange(-11));
	}
	
	@Test
	public void test3() {
		ARangeInt temp = new ARangeInt();
		assertEquals("Boundary inside negative Int testing: in range",true, temp.intRange(-10));
	}
	
	@Test
	public void test4() {
		ARangeInt temp = new ARangeInt();
		assertEquals("Inside Int testing: in range",true, temp.intRange(0));
	}
	
	@Test
	public void test5() {
		ARangeInt temp = new ARangeInt();
		assertEquals("Boundary inside positive Int testing: in range",true, temp.intRange(10));
	}
	
	@Test
	public void test6() {
		ARangeInt temp = new ARangeInt();
		assertEquals("Boundary outside positive Int testing: not in range",false, temp.intRange(11));
	}
	
	@Test
	public void test7() {
		ARangeInt temp = new ARangeInt();
		assertEquals("Large positive Int testing: not in range",false, temp.intRange(999999));
	}

}
