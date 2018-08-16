package ast2;

/**
 * Operator Class is used for representing operator for Node functionalities
 * @author Veera Venkata Sasanka Uppu
 */
public class Operator {
	String op;
	
	/**
	 * Constructor
	 * 
	 * @param op object of type String
	 */
	public Operator(String op)
	{
		this.op = op;
	}
	
	/**
	 * getOperator returns the operator in string format
	 * @return the string representation of operator 
	 */
	public String getOperator()
	{
		return op;
	}
}