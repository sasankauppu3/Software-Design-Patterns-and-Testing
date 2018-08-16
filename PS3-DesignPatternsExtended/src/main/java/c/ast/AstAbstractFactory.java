package c.ast;
/**
 * AstAbstractFactory abstract class has all methods for AstFactory and is used as a abstract 
 * factory pattern design for making expressions and statements
 * @author Veera Venkata Sasanka Uppu
 */
public abstract class AstAbstractFactory{

	/**
	 * makeNumberExpression returns a new NumberExpression Class object
	 * @param an integer
	 * @return NumberExpression Class object initialized with given parameter
	 */
	public abstract Expression makeNumberExpression(int number);
	
	/**
	 * makeNumberExpression returns a new NumberExpression Class object
	 * @param a double
	 * @return NumberExpression Class object initialized with given parameter
	 */
	public abstract Expression makeNumberExpression(double number);
	
	/**
	 * makeStringExpression returns a new StringExpression Class object
	 * @param a string
	 * @return StringExpression Class object initialized with given parameter
	 */
	public abstract Expression makeStringExpression(String text);
	
	/**
	 * makeVariableExpression returns a new VariableExpression Class object
	 * @param a Variable object
	 * @return VariableExpression Class object initialized with given parameter
	 */
	public abstract Expression makeVariableExpression(Variable var);
	
	/**
	 * makePrefixExpression returns a new PrefixExpression Class object
	 * @param an operator
	 * @param expression1
	 * @param expression2
	 * @return PrefixExpression Class object initialized with given parameter
	 */
	public abstract Expression makePrefixExpression(Operator opr, Expression exp1, Expression exp2);
	
	/**
	 * makeInfixExpression returns a new InfixExpression Class object
	 * @param an operator
	 * @param expression1
	 * @param expression2
	 * @return InfixExpression Class object initialized with given parameter
	 */
	public abstract Expression makeInfixExpression(Operator opr, Expression exp1, Expression exp2);
	
	/**
	 * makeSequence returns a new Sequence Class object
	 * @param Statement1
	 * @param Statement2
	 * @return Sequence Class object initialized with given parameter
	 */
	public abstract Statement makeSequence(Statement st1, Statement st2);
	
	/**
	 * makeAssignment returns a new Assignment Class object
	 * @param Variable
	 * @param Expression
	 * @return Assignment Class object initialized with given parameter
	 */
	public abstract Statement makeAssignment(Variable var, Expression exp2);
	
	/**
	 * makeDeclaration returns a new Declaration Class object
	 * @param Variable
	 * @return Declaration Class object initialized with given parameter
	 */
	public abstract Statement makeDeclaration(Variable var);
}