package ast;
/**
 * PrefixExpression Class implements the abstract class Expression and is used for representing 
 * two expressions in prefix format 
 * @author Veera Venkata Sasanka Uppu
 */
public class PrefixExpression extends Expression{
	
	Operator opr;
	Expression exp1;
	Expression exp2;
	
	/**
	 * Constructor
	 * 
	 * @param opr object of type Operator
	 * @param exp1 object of type Expression
	 * @param exp2 object of type Expression
	 */
	public PrefixExpression(Operator opr, Expression exp1, Expression exp2)
	{
		this.opr = opr;
		this.exp1 = exp1;
		this.exp2 = exp2;
	}
	
	@Override
	/**
	 * textRepresentation returns two expressions with operator in a prefix form
	 * @return the string representation of the prefix expression
	 */
	public String textRepresentation() {
		String text = opr.getOperator();
		text += " ";
		text += exp1.textRepresentation();
		text += " ";
		text += exp2.textRepresentation();
		
		return text;
	}
	
}
