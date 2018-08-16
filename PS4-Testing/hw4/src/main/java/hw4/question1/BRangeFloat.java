package hw4.question1;
/**
 * BRangeFloat Class is the implementation of problem 1 B which has the function to check if
 * the given float is in range (-MAX,10) or (10,MAX)
 * @author sasankauppu
 */
public class BRangeFloat {

	/**
	 * function that takes float as input and checks if it is in range (-MAX,10) or (10,MAX)
	 * @param num : the float input
	 * @return Boolean value: True if is in range else false
	 */
	public Boolean floatRange(float num)
	{
		return (num<-10 || num>10);
	}
}
