package ast2;
/**
 * AstFactory Class implements the abstract class AstAbstractFactory and is used as a abstract 
 * factory pattern design for making expressions and statements
 * @author Veera Venkata Sasanka Uppu
 */
public class AstFactory extends AstAbstractFactory{
	
	/**
	 * makeNumberExpression returns a new NumberExpression Class object
	 * @param an integer
	 * @return NumberExpression Class object initialized with given parameter
	 */
	public Expression makeNumberExpression(int number)
	{
		return new NumberExpression(number);
	}
	
	/**
	 * makeNumberExpression returns a new NumberExpression Class object
	 * @param a double
	 * @return NumberExpression Class object initialized with given parameter
	 */
	public Expression makeNumberExpression(double number)
	{
		return new NumberExpression(number);
	}
	
	/**
	 * makeStringExpression returns a new StringExpression Class object
	 * @param a string
	 * @return StringExpression Class object initialized with given parameter
	 */
	public Expression makeStringExpression(String text)
	{
		return new StringExpression(text);
	}
	
	/**
	 * makeVariableExpression returns a new VariableExpression Class object
	 * @param a Variable object
	 * @return VariableExpression Class object initialized with given parameter
	 */
	public Expression makeVariableExpression(Variable var)
	{
		return new VariableExpression(var);
	}
	
	/**
	 * makePrefixExpression returns a new PrefixExpression Class object
	 * @param an operator
	 * @param expression1
	 * @param expression2
	 * @return PrefixExpression Class object initialized with given parameter
	 */
	public Expression makePrefixExpression(Operator opr, Expression exp1, Expression exp2)
	{
		return new PrefixExpression(opr, exp1, exp2);
	}
	
	/**
	 * makeInfixExpression returns a new InfixExpression Class object
	 * @param an operator
	 * @param expression1
	 * @param expression2
	 * @return InfixExpression Class object initialized with given parameter
	 */
	public Expression makeInfixExpression(Operator opr, Expression exp1, Expression exp2)
	{
		return new InfixExpression(opr, exp1, exp2);
	}
	
	/**
	 * makeSequence returns a new Sequence Class object
	 * @param Statement1
	 * @param Statement2
	 * @return Sequence Class object initialized with given parameter
	 */
	public Statement makeSequence(Statement st1, Statement st2)
	{
		return new Sequence(st1,st2);
	}
	
	/**
	 * makeAssignment returns a new Assignment Class object
	 * @param Variable
	 * @param Expression
	 * @return Assignment Class object initialized with given parameter
	 */
	public Statement makeAssignment(Variable var, Expression exp)
	{
		return new Assignment(var, exp);
	}
	
	/**
	 * makeDeclaration returns a new Declaration Class object
	 * @param Variable
	 * @return Declaration Class object initialized with given parameter
	 */
	public Statement makeDeclaration(Variable var)
	{
		return new Declaration(var);
	}
}
