package c.ast;
/**
 * InfixExpression Class implements the abstract class Expression and is used for representing 
 * two expressions in infix format 
 * @author Veera Venkata Sasanka Uppu
 */
public class InfixExpression extends Expression{
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
	public InfixExpression(Operator opr, Expression exp1, Expression exp2)
	{
		this.opr = opr;
		this.exp1 = exp1;
		this.exp2 = exp2;
		//assigning id for the created object
		id = count;
		//storing the current object in a Node array
		storeNode(this);
		//Incrementing the static counts
		count += 1;
	}
	
	@Override
	/**
	 * textRepresentation returns two expressions with operator in a infix form
	 * @return the string representation of the infix expression
	 */
	public String textRepresentation() {
		String text = exp1.textRepresentation();
		text += " ";
		text += opr.getOperator();
		text += " ";
		text += exp2.textRepresentation();
		
		return text;
	}

}