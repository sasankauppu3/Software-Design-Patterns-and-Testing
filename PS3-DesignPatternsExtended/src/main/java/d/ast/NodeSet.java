package d.ast;

import a.bitvector.b.BitVector;
import a.bitvector.b.IBitVector;
import a.bitvector.b.Iterator;

/**
* Class NodeSet represents a set of AST Nodes.
*
*/
public class NodeSet implements Set<Node> {
	

	private IBitVector adaptee = new BitVector();
	
	Node[] nodeArr;
	
	public NodeSet()
	{
		nodeArr = new Node[0];
	}
	
	@Override
	/**
	 * Function to add a node element to the BitVector adaptee
	 * @param n the node element which needs to be added
	 */
	public void add(Node n) {
		adaptee.set(n.getId());
		
		int curSize = nodeArr.length;
		Node[] temp = new Node[curSize+1];
		
		for(int i=0;i<curSize;i++)
		{
			temp[i]=nodeArr[i];
		}
		temp[curSize] = n;
		nodeArr = temp;
	}
	
	@Override 
	/**
	 * Function to add all node elements in the argument set to the BitVector adaptee
	 * @param s set of node elements to be added
	 */
	public void addAll(Set<Node> n) {
		Iterator<Node> nodeSetIterator = n.iterator();
		
		int curSize = nodeArr.length;
		Node[] temp = new Node[curSize+n.size()];
		
		for(int i=0;i<curSize;i++)
		{
			temp[i]=nodeArr[i];
		}
		
		int c=0;
		while(nodeSetIterator.hasAnotherElement()) 
		{
			Node nodeTemp = nodeSetIterator.nextElement();
			adaptee.set(nodeTemp.getId());
			temp[curSize+c] = nodeTemp;
		}
		nodeArr = temp;
		
	}
	
	@Override 
	/**
	  * Function to remove a node element from the BitVector adaptee
	  * @param n a node which needs to be removed
	  */
	public void remove(Node n) {
		adaptee.clear(n.getId());
	}
	
	@Override 
	/**
	  * Function to check if a node element occurs in the BitVector adaptee
	  * @param n the node element which need to be checked
	  * @return true if n exists in BitVector, else false
	  */
	public boolean contains(Node n) {
		return adaptee.get(n.getId());
	}
	
	@Override 
	 /**
	  * Function that returns the number of node elements in the BitVector adaptee
	  * @return the number of node elements
	  */
	public int size() {
		return adaptee.size();
	}
	
	@Override 
	 /**
	  * Function that returns a NodeSet iterator over the set
	  * @return iterator
	  */
	public Iterator<Node> iterator() {
		return new NodeSetIterator();
	}
	
	@Override 
	/**
	 * Function that returns string representation of all the nodes
	 */
	public String toString() {
		String st = "";
		
		for (Node n : this.nodeArr) {
			st += n.textRepresentation() + " ";
		}
		st = st.trim();
		return st;
	}

	/**
	 * Private iterator class for BitVector
	 */
	private class NodeSetIterator implements Iterator<Node>{
		
		Iterator<Integer> adapteeIterator = adaptee.iterator();
		
		@Override
		/**
		 * Function to check if there are more NodeSet in the BitVector
		 * @return True if there is at least on element in the NodeSet else False
		 */
		public boolean hasAnotherElement() {
			return adapteeIterator.hasAnotherElement();
		}

		@Override
		/**
		  * Function to get next Node in the NodeSet 
		  * @return the next Node else null if it doesn't have another Node 
		  */
		public Node nextElement() {
			int i =  adapteeIterator.nextElement();
			return Node.getNode(i);
		}
	}

}