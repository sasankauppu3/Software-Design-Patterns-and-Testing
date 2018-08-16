package b.queue;

import java.util.ArrayList;

/**
 * A QueueAdapter class
 * This class represents a queue which implements the interface Queue has functionality to do all queue operations 
 * such as add, remove and peek. It uses adapter pattern.
 */

public class QueueAdapter<T> implements Queue<T>
{
	private ArrayList<T> adaptee;

	/**
	 * Constructor for QueueAdapter which initializes the ArrayList
	 */
	public QueueAdapter() {
		adaptee = new ArrayList<>();
	}
	
	@Override
	/**
	 * Function to add an element to the head of the queue
	 * @param t 	a value of type T (any primitive type) which needs to be added to queue
	 * @return True: after the element has been added to the queue
	 */
	public boolean add(T t) {
		adaptee.add(0,(T) t);
		return true;
	}

	@Override
	/**
	  * Function to remove an element from the end of the queue. Returns null if queue is empty
	  * @return the element which has been removed
	  */
	public T remove() {
		if(adaptee.isEmpty())
			return null;
		
		T removedElement = adaptee.get(adaptee.size()-1);
		adaptee.remove(adaptee.size()-1);
		
		return removedElement;
	}

	
	@Override
	/**
	  * Function to peek the head of the queue
	  * @return the head of the queue. Return null if queue is empty
	  */
	public T peek() {
		if(adaptee.isEmpty())
			return null;
		
		return adaptee.get(0);
	}
    
}
