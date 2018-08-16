package a.bitvector.b;

/**
 * A bit vector interface
 * This interface represents a bit vector which has functionality to do operations on bit vectors
 */

public interface IBitVector {
	
/**
 * Function to determine if the bit at position i is set.
 * @param i representing the number whose bit value needs to be found
 * @return True: if bit set, else False
 */
public boolean get(int i);

/**
 * Function to set the bit at position i.
 * @param i representing the number whose bit value needs to be set 
 */
public void set(int i);

/**
 * Function to clear the bit at position i.
 * @param i representing the number whose bit value needs to be cleared/set to zero
 */
public void clear(int i);

/**
 * Function to copy and set the bits in the argument BitVector b to the current BitVector
 * @param b the BitVector b whose value needs to be copied.
 */
public void copy(BitVector b);

/**
 * Function to determine the number of non-zero bits in the BitVector.
 * @return the number of non-zero bits in the BitVector.
 */
public int size();

/**
 * Iterator over the Integer values represented by this BitVector.
 */
public Iterator<Integer> iterator();
}
