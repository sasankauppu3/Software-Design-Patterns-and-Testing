package a.bitvector.b;

/**
* A generic iterator interface which can be used for iterator design pattern.
*/
public interface Iterator<T> {


/**
 * Function to check if there are more elements
 * @return True if there is one or more elements else False
 */
 boolean hasAnotherElement();

 /**
  * Function to get next element
  * @return the next element
  */
 T nextElement();
}
