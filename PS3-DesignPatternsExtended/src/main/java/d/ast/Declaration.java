package d.ast;
/**
 * Declaration Class implements the abstract class Statement and is used for declaring 
 * a variable in its textRepresentation function
 * @author Veera Venkata Sasanka Uppu
 */
public class Declaration extends Statement implements AstAccept{

	Variable var;
	
	/**
	 * Constructor
	 * 
	 * @param var object of type Variable
	 */
	public Declaration(Variable var)
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
	 * textRepresentation returns a declaration of the variable
	 * @return a string representation of variable declaration
	 */
	public String textRepresentation() {
		String text = "var ";
		text = text + var.getVariable();
		text = text + ";";
		
		return text;
	}

	@Override
	/**
	 * function that follows visitor pattern and calls visit method 
	 */
	public void accept(AstVisitor av) {
		av.visit(this);
	}
	
}