package d.ast;
/**
 * Assignment Class implements the abstract class Statement and is used for assigning 
 * a variable to an expression
 * @author Veera Venkata Sasanka Uppu
 */
public class Assignment extends Statement implements AstAccept{
	
	Variable var;
	Expression exp;
	
	/**
	 * Constructor
	 * 
	 * @param var object of type Variable
	 * @param exp object of type Expression
	 */
	public Assignment(Variable var, Expression exp) {
		this.var = var;
		this.exp = exp;
		
		//assigning id for the created object
		id = count;
		//storing the current object in a Node array
		storeNode(this);
		//Incrementing the static counts
		count += 1;
	}

	@Override
	/**
	 * textRepresentation returns an assignment of the variable to an expression
	 * @return a string representation of variable assignment
	 */
	public String textRepresentation() {
		String text = var.getVariable();
		text += " = ";
		text += exp.textRepresentation();
		text += ";";
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