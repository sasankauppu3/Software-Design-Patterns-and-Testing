package b.queue;

/**
 * A queue interface
 * This interface represents a queue which has functionality to do all queue operations 
 * such as add, remove and peek.
 */

public interface Queue<T> {

/**
 * Function to add an element to the head of the queue
 * @param t 	a value of type T (any primitive type) which needs to be added to queue
 * @return True: after the element has been added to the queue
 */
 boolean add(T t);

 
 /**
  * Function to remove an element from the end of the queue. Returns null if queue is empty
  * @return the element which has been removed
  */
 T remove();

 
 /**
  * Function to peek the head of the queue
  * @return the head of the queue. Return null if queue is empty
  */
 T peek();
}