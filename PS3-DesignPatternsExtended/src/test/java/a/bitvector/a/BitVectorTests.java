package a.bitvector.a;

import static org.junit.Assert.*;

import org.junit.Test;

import a.bitvector.a.BitVector;

/**
 * Test cases for BitVector
 */

public class BitVectorTests {

	@Test
	/**
	 * Testing for the setting a BitVector
	 */
	public void test1() {
		BitVector a = new BitVector();
		a.set(3);
		assertEquals(true, a.get(3));
	}
	
	@Test
	/**
	 * Testing for the size of a BitVector
	 */
	public void test2() {
		BitVector a = new BitVector();
		a.set(3);
		a.set(0);
		assertEquals(2, a.size());
	}
	
	@Test
	/**
	 * Testing for increasing the BitVector array dynamically
	 */
	public void test3() {
		BitVector a = new BitVector();
		a.set(3);
		a.set(0);
		a.set(45);
		assertEquals(true, a.get(45));
		assertEquals(3, a.size());
	}
	
	@Test
	/**
	 * Testing for copying a BitVector
	 */
	public void test4() {
		BitVector a = new BitVector();
		a.set(3);
		a.set(0);
		a.set(45);
		
		BitVector b = new BitVector();
		b.set(7);
		b.set(9);
		b.set(3);
		
		a.copy(b);
		assertEquals(5, a.size());
		assertEquals(true, a.get(9));
	}
	
	@Test
	/**
	 * Testing for clearing a bit in BitVector
	 */
	public void test5() {
		BitVector a = new BitVector();
		a.set(3);
		a.set(0);
		a.set(45);
		a.set(123);
		
		assertEquals(4, a.size());
		assertEquals(true, a.get(123));
		a.clear(123);
		assertEquals(3, a.size());
		assertEquals(false, a.get(123));
	}

}
