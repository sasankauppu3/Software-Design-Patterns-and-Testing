package c.ast;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.StreamHandler;
/**
 * AstFactory Class implements the abstract class AstAbstractFactory and is used as a abstract 
 * factory pattern design for making expressions and statements
 * @author Veera Venkata Sasanka Uppu
 */
public class AstFactory extends AstAbstractFactory{
	
	int numberExpressionCount;
	int stringExpressionCount;
	int variableExpressionCount;
	int prefixExpressionCount;
	int infixExpressionCount;
	int sequenceExpressionCount;
	int assignmentExpressionCount;
	int declarationExpressionCount;
	
	private static AstFactory astFactoryInstance = new AstFactory(); 

	/**
	 * getInstance activates the use of singleton pattern for this class
	 * @return the static object of this class created
	 */
	public static AstFactory getInstance(){
		return astFactoryInstance;
	}
	
	private AstFactory()
	{
		numberExpressionCount = 0;
		stringExpressionCount = 0;
		variableExpressionCount = 0;
		prefixExpressionCount = 0;
		infixExpressionCount = 0;
		sequenceExpressionCount = 0;
		assignmentExpressionCount = 0;
		declarationExpressionCount = 0;
	}
	
	/**
	 * reportCountIncrementer increments the instance counts for different Node objects 
	 * @param NodeType enum identifying which intance to increment
	 */
	void reportCountIncrementer(NodeType nt) {
		switch(nt) {
		case NODENUMBER:
			numberExpressionCount ++;
			break;
		case NODESTRING:
			stringExpressionCount ++;
			break;
		case NODEVARIABLE:
			variableExpressionCount ++;
			break;
		case NODEINFIX:
			infixExpressionCount ++;
			break;
		case NODEPREFIX:
			prefixExpressionCount ++;
			break;
		case NODEASSIGNMENT:
			assignmentExpressionCount ++;
			break;
		case NODESEQUENCE:
			sequenceExpressionCount ++;
			break;
		case NODEDECLARATION:
			declarationExpressionCount ++;
			break;
		default:
			break;
		}
	}
	
	/**
	 * makeNumberExpression returns a new NumberExpression Class object
	 * @param an integer
	 * @return NumberExpression Class object initialized with given parameter
	 */
	public Expression makeNumberExpression(int number)
	{
		reportCountIncrementer(NodeType.NODENUMBER);
		return new NumberExpression(number);
	}
	
	/**
	 * makeNumberExpression returns a new NumberExpression Class object
	 * @param a double
	 * @return NumberExpression Class object initialized with given parameter
	 */
	public Expression makeNumberExpression(double number)
	{
		reportCountIncrementer(NodeType.NODENUMBER);
		return new NumberExpression(number);
	}
	
	/**
	 * makeStringExpression returns a new StringExpression Class object
	 * @param a string
	 * @return StringExpression Class object initialized with given parameter
	 */
	public Expression makeStringExpression(String text)
	{
		reportCountIncrementer(NodeType.NODESTRING);
		return new StringExpression(text);
	}
	
	/**
	 * makeVariableExpression returns a new VariableExpression Class object
	 * @param a Variable object
	 * @return VariableExpression Class object initialized with given parameter
	 */
	public Expression makeVariableExpression(Variable var)
	{
		reportCountIncrementer(NodeType.NODEVARIABLE);
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
		reportCountIncrementer(NodeType.NODEPREFIX);
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
		reportCountIncrementer(NodeType.NODEINFIX);
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
		reportCountIncrementer(NodeType.NODESEQUENCE);
		return new Sequence(st1,st2);
	}
	
	/**
	 * makeAssignment returns a new Assignment Class object
	 * @param Variable
	 * @param Expression
	 * @return Assignment Class object initialized with given parameter
	 */
	public Statement makeAssignment(Variable var, Expression exp2)
	{
		reportCountIncrementer(NodeType.NODEASSIGNMENT);
		return new Assignment(var, exp2);
	}
	
	/**
	 * makeDeclaration returns a new Declaration Class object
	 * @param Variable
	 * @return Declaration Class object initialized with given parameter
	 */
	public Statement makeDeclaration(Variable var)
	{
		reportCountIncrementer(NodeType.NODEDECLARATION);
		return new Declaration(var);
	}
	
	/**
	 * logReport writes a list of counts of instances of Node created with AstFactory object to logger
	 */
	public void report()
	{
		final Logger logoutput = Logger.getLogger(AstFactory.class.getName());
		
		String outputText = "NumberExpression count: {0} \n";
		outputText += "StringExpression count: {1} \n";
		outputText += "VariableExpression count: {2} \n";
		outputText += "PrefixExpression count: {3} \n";
		outputText += "InfixExpression count: {4} \n";
		outputText += "Sequence count: {5} \n";
		outputText += "Assignment count: {6} \n";
		outputText += "Declaration count: {7} \n";
		
		logoutput.setUseParentHandlers(false);
		logoutput.addHandler(new StreamHandler(System.out, new SimpleFormatter()));
		logoutput.log(Level.INFO, outputText,new Object[]{numberExpressionCount,stringExpressionCount, variableExpressionCount,prefixExpressionCount,infixExpressionCount,sequenceExpressionCount,assignmentExpressionCount,declarationExpressionCount});
	}
	
	/**
	 * report returns list of counts of instances of Node created with AstFactory object
	 * @return list of integer counts
	 */
	public List<Integer> getReport()
	{
		return Arrays.asList(numberExpressionCount,stringExpressionCount,variableExpressionCount,prefixExpressionCount,infixExpressionCount,sequenceExpressionCount,assignmentExpressionCount,declarationExpressionCount);
	}
	
}
