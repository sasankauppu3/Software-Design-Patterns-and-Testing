package ast4;
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