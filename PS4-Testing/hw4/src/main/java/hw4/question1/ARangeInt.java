package hw4.question1;

/**
 * ARangeInt Class is the implementation of problem 1 A which has the function to check if
 * the given integer is in range [-10,10]
 * @author sasankauppu
 */
public class ARangeInt {
	
	/**
	 * function that takes integer as input and checks if it is in range [-10,10]
	 * @param num : the integer input
	 * @return Boolean value: True if is in range else false
	 */
	public Boolean intRange(int num)
	{
		return (num>=-10 && num<=10);
	}
}
