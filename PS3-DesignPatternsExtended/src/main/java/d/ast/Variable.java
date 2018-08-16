package d.ast;
/**
 * Variables Class is used for representing variable for Node functionalities
 * @author Veera Venkata Sasanka Uppu
 */
public class Variable {
	String v;
	
	/**
	 * Constructor
	 * 
	 * @param v object of type String
	 */
	public Variable(String v) {
		this.v = v;
	}
	
	/**
	 * getVariable returns the variable in string format
	 * @return the string representation of variable 
	 */
	public String getVariable()
	{
		return v;
	}
}