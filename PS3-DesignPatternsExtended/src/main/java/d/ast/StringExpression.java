package d.ast;
/**
 * StringExpression Class implements the abstract class Expression and is used for representing 
 * a string 
 * @author Veera Venkata Sasanka Uppu
 */
public class StringExpression extends Expression implements AstAccept{

	String text;
	
	/**
	 * Constructor
	 * 
	 * @param text object of type string
	 */
	public StringExpression(String text){
		this.text = text;

		//assigning id for the created object
		id = count;
		//storing the current object in a Node array
		storeNode(this);
		//Incrementing the static counts
		count += 1;
	} 
	
	@Override
	/**
	 * textRepresentation returns the string expression
	 * @return the string object
	 */
	public String textRepresentation() {
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