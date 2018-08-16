package d.ast;

/**
 * Interface AstAccept which is implemented by sucblasses of Node to implement the accept method
 *
 */

public interface AstAccept {
	
	/**
	 * function that follows visitor pattern and calls accept
	 * @param AstVisitor class object
	 */
	public void accept(AstVisitor av);
	
}
