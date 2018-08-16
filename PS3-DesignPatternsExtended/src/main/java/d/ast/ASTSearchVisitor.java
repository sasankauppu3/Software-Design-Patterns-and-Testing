package d.ast;

import a.bitvector.b.Iterator;

/**
 * Class ASTSearchVisitor implements AstVisitor searches for a variable 
 * with assignment and declaration
 * @author sasankauppu
 */
public class ASTSearchVisitor implements AstVisitor{
	
	NodeSet nodeSet;
	
	public ASTSearchVisitor() {
		nodeSet = new NodeSet();
	}

	@Override
	public void visit(InfixExpression i) {
		//Do Nothing because search is not responsible for InfixExpression
	}

	@Override
	public void visit(PrefixExpression p) {
		//Do Nothing because search is not responsible for PrefixExpression
	}

	@Override
	public void visit(NumberExpression n) {
		//Do Nothing because search is not responsible for NumberExpression
	}

	@Override
	public void visit(StringExpression s) {
		//Do Nothing because search is not responsible for StringExpression
	}

	@Override
	public void visit(VariableExpression v) {
		//Do Nothing because search is not responsible for VariableExpression
	}

	@Override
	/**
	 * Function to add declaration Nodes to nodeSet
	 * @param Declaration node
	 */
	public void visit(Declaration d) {
			nodeSet.add(d);
	}

	@Override
	/**
	 * Function to add assignment Nodes to nodeSet
	 * @param Assignment node
	 */
	public void visit(Assignment a) {
			nodeSet.add(a);
	}

	@Override
	public void visit(Sequence s) {
		//Do Nothing because search is not responsible for Sequence
	}
	
	/**
	 * Function to return NodeSet after AstSearch Visitor has done search for the given variable
	 * @return NodeSet which has nodes associated to the given variable
	 */
	public NodeSet getNodeSet(Variable var)
	{
		NodeSet temp = new NodeSet();
		Iterator<Node> ns = nodeSet.iterator();
		Node a;
		while(ns.hasAnotherElement())
		{
			a = ns.nextElement();
			if(a instanceof Assignment )
			{
				Assignment a1 = (Assignment) a;
				if(var.getVariable().equals(a1.var.getVariable()))
					temp.add(a);
			}
			else if(a instanceof Declaration)
			{
				Declaration a1 = (Declaration) a;
				if(var.getVariable().equals(a1.var.getVariable()))
					temp.add(a);
			}
		}
		
		return temp;
	}

}
