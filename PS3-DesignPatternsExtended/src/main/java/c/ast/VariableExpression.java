package c.ast;
/**
 * VariableExpression Class implements the abstract class Expression and is used for representing 
 * a variable 
 * @author Veera Venkata Sasanka Uppu
 */
public class VariableExpression extends Expression{
	
	Variable var;

	/**
	 * Constructor
	 * 
	 * @param var object of type Variable
	 */
	public VariableExpression(Variable var)
	{
		this.var = var;

		//assigning id for the created object
		id = count;
		//storing the current object in a Node array
		storeNode(this);
		//Incrementing the static counts
		count += 1;
	}
	
	@Override
	/**
	 * textRepresentation returns the variable expression in string format
	 * @return the string representation of variable 
	 */
	public String textRepresentation() {
		String text;
		text = var.getVariable();
		return text;
	}

}