package b.queue;

import org.junit.Test;

import b.queue.Queue;
import b.queue.QueueAdapter;
import junit.framework.TestCase;

/**
 * Test cases for Queue class
 */

public class QueueTests extends TestCase {
	
	@Test
	/**
	 * Testing the QueueAdapter for integer type and peek functionality
	 */
	public void test1()
    {
    		Queue<Integer> queue = new QueueAdapter<Integer>();
    		queue.add(3);
    		assertEquals((Integer)3, queue.peek());
    }
	
	@Test
	/**
	 * Testing the QueueAdapter for integer type and peek functionality after adding multiple elements
	 */
	public void test2()
    {
    		Queue<Integer> queue = new QueueAdapter<Integer>();
    		queue.add(3);
    		queue.add(5);
    		assertEquals((Integer)5, queue.peek());
    }
	
	@Test
	/**
	 * Testing the QueueAdapter for integer type and remove functionality after adding multiple elements
	 */
	public void test3()
    {
    		Queue<Integer> queue = new QueueAdapter<Integer>();
    		queue.add(3);
    		queue.add(5);
    		assertEquals((Integer)3, queue.remove());
    }
	
	
	@Test
	/**
	 * Testing the QueueAdapter for String type and add/peek functionality
	 */
	public void test4()
    {
		Queue<String> queue = new QueueAdapter<String>();
    		assertEquals(true, queue.add("a"));
    		assertEquals("a", queue.peek());
    }
	
	@Test
	/**
	 * Testing the QueueAdapter for String type and remove/peek functionality after adding multiple elements
	 */
	public void test6()
    {
    		Queue<String> queue = new QueueAdapter<String>();
    		queue.add("a");
    		queue.add("b");
    		assertEquals("b", queue.peek());
    		assertEquals("a", queue.remove());
    }
}
