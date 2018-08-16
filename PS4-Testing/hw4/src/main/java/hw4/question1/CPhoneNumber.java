package hw4.question1;
/**
 * CPhoneNumber Class is the implementation of problem 1 C which has the function to check if
 * the given PhoneNumber is legitimate
 * @author sasankauppu
 */
public class CPhoneNumber {
	
	/**
	 * function that takes string as input and checks if it is a legitimate phone number
	 * Legitimate phone number implies: properly formed (10 digits),
	 * does not begin with a 1 or 0,
	 * the first three digits cannot be 555
	 * @param pno: the string input
	 * @return Boolean value: True if the given string can be a legitimate phone number
	 */
	public Boolean validPhoneNumber(String pno)
	{
		if (!pno.matches("[0-9]+") || pno.length() != 10) 
			return false;
		if (pno.startsWith("1") || pno.startsWith("0") || pno.startsWith("555"))
			return false;
		
		return true;
	}
}
