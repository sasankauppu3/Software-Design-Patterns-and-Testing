package d.ast;

import a.bitvector.b.Iterator;

/**
* A generic set interface
*/

public interface Set<T> {

/**
 * Function to add an element to the set
 * @param t the element which needs to be added
 */
void add(T t);


/**
 * Function to add all elements in the argument set
 * @param s set of elements to be added
 */
 void addAll(Set<T> s);

 /**
  * Function to check if an element occurs in the set
  * @param t the element which need to be checked
  * @return true if t exists, else false
  */
 boolean contains(T t);

 /**
  * Function to remove an element from the set
  * @param t which needs to be removed
  */
 void remove(T t);
 
 /**
  * Function that returns the number of arguments in the set
  * @return the number of arguments
  */
 int size(); 

 /**
  * Function that returns an iterator over the set
  * @return iterator
  */
 Iterator<T> iterator();
}