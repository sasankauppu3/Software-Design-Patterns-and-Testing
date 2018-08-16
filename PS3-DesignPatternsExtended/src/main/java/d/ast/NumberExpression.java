package d.ast;
/**
 * NumberExpression Class implements the abstract class Expression and is used for representing 
 * a number 
 * @author Veera Venkata Sasanka Uppu
 */
public class NumberExpression extends Expression implements AstAccept{
	
	String numText;
	
	/**
	 * Constructor
	 * 
	 * @param number object of type int
	 */
	public NumberExpression(int number){
		numText = String.valueOf(number);
		
		//assigning id for the created object
		id = count;
		//storing the current object in a Node array
		storeNode(this);
		//Incrementing the static counts
		count += 1;
	}
	
	/**
	 * Constructor
	 * 
	 * @param number object of type double
	 */
	public NumberExpression(double number){
		numText = String.valueOf(number);
		
		//assigning id for the created object
		id = count;
		//storing the current object in a Node array
		storeNode(this);
		//Incrementing the static counts
		count += 1;
	}
	
	@Override
	/**
	 * textRepresentation returns the number expression in string format
	 * @return the string representation of number 
	 */
	public String textRepresentation() {
		return numText;
	}
	
	@Override
	/**
	 * function that follows visitor pattern and calls visit method 
	 */
	public void accept(AstVisitor av) {
		av.visit(this);
	}

}