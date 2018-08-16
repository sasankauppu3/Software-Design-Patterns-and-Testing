package d.ast;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ASTSearchVisitorTests {
	@Test
	/**
	 * Testing for the text representation of the set of statements: var x; x = 1 + 2;
	 * and var y; y = hello;" and testing AstSearchVisitor 
	 */
	public void test1(){
		AstFactory astf1 = AstFactory.getInstance();
		AstFactory astf2 = AstFactory.getInstance();
		
		Variable x = new Variable("x");
		Variable y = new Variable("y");
		Operator plus = new Operator("+");
		
		Expression one = astf1.makeNumberExpression(1);
		Expression two = astf1.makeNumberExpression(2);
		
		Expression exp1 = astf1.makeInfixExpression(plus, one, two);
		Expression exp3 = astf2.makeStringExpression("hello");
		
		Statement st1 = astf1.makeDeclaration(x);
		Statement st3 = astf1.makeAssignment(x,  (Expression) Node.getNode(exp1.getId()));

		Statement st2 = astf2.makeDeclaration(y);
		Statement st5 = astf2.makeAssignment(y,(Expression)Node.getNode(exp3.getId()));
		
		Statement seq1 = astf1.makeSequence((Statement) Node.getNode(st1.getId()), (Statement) Node.getNode(st3.getId()));
		
		Statement seq3 = astf2.makeSequence((Statement) Node.getNode(st2.getId()), (Statement) Node.getNode(st5.getId()));
		assertEquals("var x; x = 1 + 2;", seq1.textRepresentation());
		assertEquals("var y; y = hello;" , seq3.textRepresentation());
		
		AstAcceptImpl astAccept = new AstAcceptImpl();
		AstNodeCountVisitor av = new AstNodeCountVisitor();
		ASTSearchVisitor asv = new ASTSearchVisitor();
		
		astAccept.accept(av);
		astAccept.accept(asv);

		assertEquals("var y; y = hello;", asv.getNodeSet(y).toString());
		assertEquals("var x; x = 1 + 2;", asv.getNodeSet(x).toString());
		assertEquals(1, av.infixCount);
		assertEquals(2, av.assignmentCount);
		assertEquals(2, av.numberCount);
		assertEquals(2, av.declarationCount);
		assertEquals(1, av.stringCount);
		assertEquals(2, av.sequenceCount);
		assertEquals(0, av.variableCount);
		assertEquals(0, av.prefixCount);
	}
}
