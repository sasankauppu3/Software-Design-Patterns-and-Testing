package question2tests;

import static org.junit.Assert.*;

import org.junit.Test;

import hw4.question2.HomeworkImpl;

public class Q2test {
	
	HomeworkImpl hw = new HomeworkImpl();
	
	@Test
	public void test_square_1() {
		assertEquals("Square for 0 is 0",0, hw.sqr(0));
	}
	
	@Test 
	public void test_square_2() {
		assertEquals("Square for 3 is 9",9, hw.sqr(3));
	}
	
	@Test
	public void test_square_3() {
		assertEquals("Square for -3 is 9",9, hw.sqr(-3));
	}
	
	@Test
	public void test_squareroot_1() { 
		assertEquals("Square root for 4 is 2",2, hw.sqrt(4),0.0001);
	}

	@Test
	public void test_squareroot_2() { 
		assertEquals("Square root for 2 is ~1.414",1.414, hw.sqrt(2),0.001);
	}
	
	@Test
	public void test_squareroot_3() { 
		assertEquals("Square root for neagtive numbers is NaN",Double.NaN, hw.sqrt(-4),0);
	}
	
	@Test
	public void test_squareroot_4() { 
		assertEquals("Square root for 0 is 0",0, hw.sqrt(0),0);
	}
	
	@Test
	public void test_factorial_1() { 
		assertEquals("Factorial for 0 is 1",1, hw.factorial(0));
	}
	
	@Test
	public void test_factorial_2() { 
		assertEquals("Factorial for 1 is 1",1, hw.factorial(1));
	}
	
	@Test
	public void test_factorial_3() { 
		assertEquals("Factorial for 2 is 2",2, hw.factorial(2));
	}
	
	@Test
	public void test_factorial_4() { 
		assertEquals("Factorial for 6 is 720",720, hw.factorial(6));
	}
	
	@Test
	public void test_factorial_5() { 
		assertEquals("Factorial for negative number is NaN",(int)Double.NaN, hw.factorial(-3));
	}
	
}
