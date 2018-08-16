package d.ast;

/**
 * Class AstAcceptImpl which implements AstAccept and implements visitor pattern
 * by calling accept on all the nodes
 *
 */

public class AstAcceptImpl implements AstAccept{
	
	
	@Override
	/**
	 * function that follows visitor pattern and calls accept method on all the nodes
	 * @param AstVisitor object
	 */
	public void accept(AstVisitor av) {
		Node[] nodeList = Node.nodeArr;
		
		for(int i=0;i<nodeList.length; i++)
		{
			nodeList[i].accept(av);
		}
	}
	
}
