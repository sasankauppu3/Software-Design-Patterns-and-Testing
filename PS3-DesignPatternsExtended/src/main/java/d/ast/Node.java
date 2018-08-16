package d.ast;

import java.util.NoSuchElementException;

/**
 * Abstract class which consists signature for Node type
 */
public abstract class Node {
	
	//Id is used by subclasses of Node to store the unique identifier for each object
	int id;
	//Static variable count has the number of instances created
	static int count = 0;
	//Node Array contains all the instances of Node and its sub classes
	static Node[] nodeArr = new Node[0];
	
	/**
	 * textRepresentation returns Node in a textual representation format
	 * @return a string representation of Node
	 */
	public abstract String textRepresentation();
	
	/**
	 * Function that returns unique identifier for each node.
	 * @return the unique identifier
	 */
	public int getId()
	{
		return id;
	}

	/**
	 * Function to reverse mapping from Nodes to their unique identifiers
	 * @param id the id whose node is to be obtained
	 * @return the Node object mapping the equivalent id
	 */
	public static Node getNode(int id) {
		
		if(id>nodeArr.length)
		{
			throw new NoSuchElementException();
		}
		
		return nodeArr[id];
	}
	
	/**
	 * Function to store Node object to the Node array
	 * @param t Node which needs to be added
	 */
	public void storeNode(Node t)
	{
		int curSize = nodeArr.length;
		Node[] temp = new Node[curSize+1];
		
		for(int i=0;i<curSize; i++)
		{
			temp[i] = nodeArr[i];
		}
		temp[curSize] = t;
		nodeArr = temp;
	}
	
	/**
	 * function that follows visitor pattern and calls visit method 
	 */
	public abstract void accept(AstVisitor ast);
	
}