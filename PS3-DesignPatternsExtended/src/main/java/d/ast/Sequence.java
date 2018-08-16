package d.ast;
/**
 * Sequence Class implements the abstract class Statement and is used for joining 
 * two Statements in its textRepresentation function
 * @author Veera Venkata Sasanka Uppu
 */
public class Sequence extends Statement implements AstAccept{

	Statement st1;
	Statement st2;
	
	/**
	 * Constructor
	 * 
	 * @param st1 object of type Statement
	 * @param st2 object of type Statement
	 */
	public Sequence(Statement st1, Statement st2) {
		this.st1 = st1;
		this.st2 = st2;
		
		//assigning id for the created object
		id = count;
		//storing the current object in a Node array
		storeNode(this);
		//Incrementing the static counts
		count += 1;
	}

	@Override
	/**
	 * textRepresentation returns two statements in a sequence order
	 * @return a string representation of two statements
	 */
	public String textRepresentation() {
		String text = st1.textRepresentation();
		text += " ";
		text += st2.textRepresentation();
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