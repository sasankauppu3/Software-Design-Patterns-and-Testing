package d.ast;

/**
 * Class AstNodeCountVisitor which implements AstVisitor keeps track
 * of counts of all instances created
 * @author sasankauppu
 */
public class AstNodeCountVisitor implements AstVisitor{

	int infixCount = 0;
	int prefixCount = 0;
	int numberCount = 0;
	int stringCount = 0;
	int variableCount = 0;
	int declarationCount =0;
	int assignmentCount = 0;
	int sequenceCount = 0;
	
	@Override
	/**
	 * Function to count the number of InfixExpression instances
	 */
	public void visit(InfixExpression i) {
		infixCount++;
	}

	@Override
	/**
	 * Function to count the number of PrefixExpression instances
	 */
	public void visit(PrefixExpression p) {
		prefixCount++;
	}

	@Override
	/**
	 * Function to count the number of NumberExpression instances
	 */
	public void visit(NumberExpression n) {
		numberCount++;
	}

	@Override
	/**
	 * Function to count the number of StringExpression instances
	 */
	public void visit(StringExpression s) {
		stringCount++;
	}

	@Override
	/**
	 * Function to count the number of VariableExpression instances
	 */
	public void visit(VariableExpression v) {
		variableCount++;
	}

	@Override
	/**
	 * Function to count the number of Declaration instances
	 */
	public void visit(Declaration d) {
		declarationCount++;
	}

	@Override
	/**
	 * Function to count the number of Assignment instances
	 */
	public void visit(Assignment a) {
		assignmentCount++;
	}

	@Override
	/**
	 * Function to count the number of Sequence instances
	 */
	public void visit(Sequence s) {
		sequenceCount++;
	}


}
