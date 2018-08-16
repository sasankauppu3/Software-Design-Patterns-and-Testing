package question1tests;

import static org.junit.Assert.*;
import hw4.question1.*;
import org.junit.Test;

public class testq1b {

	BRangeFloat brf = new BRangeFloat();
	
	@Test
	public void test1() {
		assertEquals("Large negative Float testing: in range",true, brf.floatRange(-9999.999f));
	}
	
	@Test
	public void test2() {
		assertEquals("Boundary inside negative Float testing: in range",true, brf.floatRange(-10.1233f));
	}
	
	@Test
	public void test3() {
		assertEquals("Boundary outside negative Float testing: not in range",false, brf.floatRange(-10.0f));
	}
	
	@Test
	public void test4() {
		assertEquals("outside Float testing: not in range",false, brf.floatRange(0f));
	}
	
	@Test
	public void test5() {
		assertEquals("Boundary outside positive Float testing: not in range",false, brf.floatRange(10.0f));
	}
	
	@Test
	public void test6() {
		assertEquals("Boundary inside positive Float testing: in range",true, brf.floatRange(10.908f));
	}
	
	@Test
	public void test7() {
		assertEquals("Large positive Float testing: in range",true, brf.floatRange(9999.987f));
	}

}
