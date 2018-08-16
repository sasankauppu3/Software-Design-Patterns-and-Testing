package a.bitvector.a;

/**
* A generic iterator has to be implemented for part b
*/
public interface Iterator<T> {

 /**
  * Check if there are more elements
  */
 boolean hasAnotherElement();
 
 /**
  * Return the next element
  */
 T nextElement();
}
