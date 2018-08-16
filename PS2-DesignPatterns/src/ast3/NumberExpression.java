package ast3;
/**
 * NumberExpression Class implements the abstract class Expression and is used for representing 
 * a number 
 * @author Veera Venkata Sasanka Uppu
 */
public class NumberExpression extends Expression{
	
	String numText;
	
	/**
	 * Constructor
	 * 
	 * @param number object of type int
	 */
	public NumberExpression(int number){
		numText = String.valueOf(number);
	}
	
	/**
	 * Constructor
	 * 
	 * @param number object of type double
	 */
	public NumberExpression(double number){
		numText = String.valueOf(number);
	}
	
	@Override
	/**
	 * textRepresentation returns the number expression in string format
	 * @return the string representation of number 
	 */
	public String textRepresentation() {
		return numText;
	}

}