package ast;
/**
 * Declaration Class implements the abstract class Statement and is used for declaring 
 * a variable in its textRepresentation function
 * @author Veera Venkata Sasanka Uppu
 */
public class Declaration extends Statement{

	Variable var;
	
	/**
	 * Constructor
	 * 
	 * @param var object of type Variable
	 */
	public Declaration(Variable var)
	{
		this.var = var;
	}
	
	@Override
	/**
	 * textRepresentation returns a declaration of the variable
	 * @return a string representation of variable declaration
	 */
	public String textRepresentation() {
		String text = "var ";
		text = text + var.getVariable();
		text = text + ";";
		
		return text;
	}
	
}
