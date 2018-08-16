package d.ast;

/**
 * AstVisitor interface which has visit method implementations for all Node types
 * @author sasankauppu
 *
 */
public interface AstVisitor {
	
	/**
	 * Function to visit the InfixExpression instances
	 */
	public void visit(InfixExpression i);
	
	/**
	 * Function to visit the PrefixExpression instances
	 */
	public void visit(PrefixExpression p);
	
	/**
	 * Function to visit the NumberExpression instances
	 */
	public void visit(NumberExpression n);
	
	/**
	 * Function to visit the StringExpression instances
	 */
	public void visit(StringExpression s);
	
	/**
	 * Function to visit the VariableExpression instances
	 */
	public void visit(VariableExpression v);
	
	/**
	 * Function to visit the Declaration instances
	 */
	public void visit(Declaration d);
	
	/**
	 * Function to visit the Assignment instances
	 */
	public void visit(Assignment a);
	
	/**
	 * Function to visit the Sequence instances
	 */
	public void visit(Sequence s);
}
