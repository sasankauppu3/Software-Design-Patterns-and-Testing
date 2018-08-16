import static org.junit.Assert.*;
import java.util.Arrays;
import org.junit.Test;

/**
 * Test Cases for rangeCalculator method in RangePrinter.java class
 */

public class RangePrinterTest {

	RangePrinter rp;
	
    public RangePrinterTest() {
		// TODO Auto-generated constructor stub
    		rp = new RangePrinter();
    	}
    
    /**
     * The range for (3,7) should be (5)
     */
	@Test
	public void test1() {
		assertEquals(Arrays.asList(5), rp.rangeCalculator(3, 7));
	}
	
	/**
     * The range for (3,4) should be () as there is no number in between
     */
	@Test
	public void test2() {
		assertEquals(Arrays.asList(), rp.rangeCalculator(3, 4));
	}
	
	/**
     * The range for (3,3) should be () as there is no number in between
     */
	@Test
	public void test3() {
		assertEquals(Arrays.asList(), rp.rangeCalculator(3, 3));
	}
	
	/**
     * The range for (3,1) should be () as there is no number in between
     */
	@Test
	public void test4() {
		assertEquals(Arrays.asList(), rp.rangeCalculator(3, 1));
	}
	
	/**
     * The range for (-2, 3) should be (-1,1) 
     */
	@Test
	public void test5() {
		assertEquals(Arrays.asList(-1,1), rp.rangeCalculator(-2, 3));
	}

}
