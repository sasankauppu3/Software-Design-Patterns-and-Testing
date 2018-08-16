package d.ast;
import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;


/**
 * Test Cases for Ast
 */


public class ASTNodeCountVisitorTests {
	
	
	@Test
	/**
	 * Testing for the text representation of the set of statements: var x; x = 1 + 2;
	 * and var y; y = hello;" and testing AstNodeCounter 
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
		
		astAccept.accept(av);
		assertEquals(1, av.infixCount);
		assertEquals(2, av.assignmentCount);
		assertEquals(2, av.numberCount);
		assertEquals(2, av.declarationCount);
		assertEquals(1, av.stringCount);
		assertEquals(2, av.sequenceCount);
		assertEquals(0, av.variableCount);
		assertEquals(0, av.prefixCount);
	}
	
	@Test
	/**
	 * Testing for the text representation of the set of statements: var x; x = 1 + 2;
	 * and var y; y = hello;" and testing NodeSet class.
	 */
	public void test2(){
		AstFactory astf1 = AstFactory.getInstance();
		AstFactory astf2 = AstFactory.getInstance();
		NodeSet nodeset1 = new NodeSet();
		NodeSet nodeset2 = new NodeSet();
		
		Variable x = new Variable("x");
		Variable y = new Variable("y");
		Operator plus = new Operator("+");
		
		Expression one = astf1.makeNumberExpression(1);
		nodeset1.add(one);
		Expression two = astf1.makeNumberExpression(2);
		nodeset1.add(two);
		
		Expression exp1 = astf1.makeInfixExpression(plus, one, two);
		nodeset1.add(exp1);
		Expression exp3 = astf2.makeStringExpression("hello");
		nodeset1.add(exp3);
		
		Statement st1 = astf1.makeDeclaration(x);
		nodeset2.add(st1);
		Statement st3 = astf1.makeAssignment(x,  (Expression) Node.getNode(exp1.getId()));
		nodeset2.add(st3);
		
		Statement st2 = astf2.makeDeclaration(y);
		nodeset2.add(st2);
		Statement st5 = astf2.makeAssignment(y,(Expression)Node.getNode(exp3.getId()));
		nodeset2.add(st5);
		
		Statement seq1 = astf1.makeSequence((Statement) Node.getNode(st1.getId()), (Statement) Node.getNode(st3.getId()));
		nodeset2.add(seq1);
		Statement seq3 = astf2.makeSequence((Statement) Node.getNode(st2.getId()), (Statement) Node.getNode(st5.getId()));
		nodeset2.add(seq3);
		
		assertEquals("var x; x = 1 + 2;", seq1.textRepresentation());
		assertEquals("var y; y = hello;" , seq3.textRepresentation());
		assertEquals(4,nodeset1.size());
		assertEquals(6,nodeset2.size());
		assertEquals(true,nodeset1.contains(exp1));
		assertEquals(false,nodeset1.contains(st1));
		nodeset1.addAll(nodeset2);
		assertEquals(10,nodeset1.size());
		assertEquals(true,nodeset1.contains(st1));
		nodeset1.remove(st1);
		assertEquals(false,nodeset1.contains(st1));
	}
	
	@Test
	/**
	 * Testing for the text representation of the set of statements: var x; x = 1 + 2; x = / x 2;
	 * and var y; y = hello;"
	 */
	public void test3(){
		AstFactory astf1 = AstFactory.getInstance();
		AstFactory astf2 = AstFactory.getInstance();
		
		Variable x = new Variable("x");
		Variable y = new Variable("y");
		Operator plus = new Operator("+");
		Operator div = new Operator("/");
		
		Expression vex = astf1.makeVariableExpression(x);
		Expression one = astf1.makeNumberExpression(1);
		Expression two = astf1.makeNumberExpression(2);
		
		Expression exp1 = astf1.makeInfixExpression(plus, one, two);
		Expression exp2 = astf1.makePrefixExpression(div, vex, two);
		Expression exp3 = astf2.makeStringExpression("hello");
		
		Statement st1 = astf1.makeDeclaration(x);
		Statement st3 = astf1.makeAssignment(x, exp1);
		Statement st4 = astf1.makeAssignment(x, exp2);

		Statement st2 = astf2.makeDeclaration(y);
		Statement st5 = astf2.makeAssignment(y,exp3);
		
		Statement seq1 = astf1.makeSequence(st1, st3);
		Statement seq2 = astf1.makeSequence(seq1, st4);
		
		Statement seq3 = astf2.makeSequence(st2, st5);
		assertEquals("var x; x = 1 + 2; x = / x 2;", seq2.textRepresentation());
		assertEquals("var y; y = hello;" , seq3.textRepresentation());
		assertEquals(astf1.getReport(), Arrays.asList(6,3,1,1,3,7,7,6) );
		astf1.report();
		assertEquals(astf2.getReport(), Arrays.asList(6,3,1,1,3,7,7,6) );
		astf2.report();
	}

	
	@Test
	/**
	 * Testing for the text representation of the set of statements: var x; x = 1 + 2;
	 */
	public void test4(){
		AstFactory astf = AstFactory.getInstance();
		Variable x = new Variable("x");
		Operator plus = new Operator("+");
		
		Expression one = astf.makeNumberExpression(1);
		Expression two = astf.makeNumberExpression(2);
		Expression exp = astf.makeInfixExpression(plus, one, two);
		Statement decl = astf.makeDeclaration(x);
		Statement assign = astf.makeAssignment(x, exp);
		Statement seq = astf.makeSequence(decl, assign);
		assertEquals("var x; x = 1 + 2;", seq.textRepresentation());
	}
	
	@Test
	/**
	 * Testing for the text representation of the set of statements: var x; x = 1; var y; y = 3.05; y = x + 2.05;
	 */
	public void test5(){
		AstFactory astf = AstFactory.getInstance();
		Variable x = new Variable("x");
		Variable y = new Variable("y");
		Operator plus = new Operator("+");
		
		Expression vex = astf.makeVariableExpression(x);
		Expression one = astf.makeNumberExpression(1);
		Expression two = astf.makeNumberExpression(2.05);
		Expression three = astf.makeNumberExpression(3.05);
		
		Statement decl1 = astf.makeDeclaration(x);
		Statement decl2 = astf.makeDeclaration(y);
		Statement assign1 = astf.makeAssignment(x, one);
		Statement assign2 = astf.makeAssignment(y, three);
		
		Expression exp = astf.makeInfixExpression(plus, vex, two);
		Statement assign3 = astf.makeAssignment(y, exp);
		
		Statement seq = astf.makeSequence(decl1, assign1);
		Statement seq1 = astf.makeSequence(seq, decl2);
		Statement seq2 = astf.makeSequence(seq1, assign2);
		Statement seq3 = astf.makeSequence(seq2, assign3);
		assertEquals("var x; x = 1; var y; y = 3.05; y = x + 2.05;", seq3.textRepresentation());
	}
	
	@Test
	/**
	 * Testing for the text representation of the set of statements: var x; x = / * 6 3 2;
	 */
	public void test6(){
		AstFactory astf = AstFactory.getInstance();
		Variable x = new Variable("x");
		Operator div = new Operator("/");
		Operator mul = new Operator("*");
		
		Expression six = astf.makeNumberExpression(6);
		Expression three = astf.makeNumberExpression(3);
		Expression two = astf.makeNumberExpression(2);
		
		Expression exp = astf.makePrefixExpression(mul, six, three);
		Expression exp1 = astf.makePrefixExpression(div, exp, two);
		
		Statement decl = astf.makeDeclaration(x);
		Statement assign = astf.makeAssignment(x, exp1);
		Statement seq = astf.makeSequence(decl, assign);
		assertEquals( "var x; x = / * 6 3 2;", seq.textRepresentation());
	}
	
	@Test
	/**
	 * Testing for the text representation of the set of statements: var x; x = hello world!;
	 */
	public void test7(){
		AstFactory astf = AstFactory.getInstance();
		Variable x = new Variable("x");
		Expression exp = astf.makeStringExpression("hello world!");

		Statement decl = astf.makeDeclaration(x);
		Statement assign = astf.makeAssignment(x, exp);
		Statement seq = astf.makeSequence(decl, assign);
		assertEquals("var x; x = hello world!;", seq.textRepresentation());
	}
	
	@Test
	/**
	 * Testing for the text representation of the set of statements: var x; x = 1 + 2 + 3 + 4; x = x / 3 + 2 * x;
	 */
	public void test8(){
		AstFactory astf = AstFactory.getInstance();
		Variable x = new Variable("x");
		Operator plus = new Operator("+");
		Operator div = new Operator("/");
		Operator mul = new Operator("*");
		
		Expression vex = astf.makeVariableExpression(x);
		Expression one = astf.makeNumberExpression(1);
		Expression two = astf.makeNumberExpression(2);
		Expression three = astf.makeNumberExpression(3);
		Expression four = astf.makeNumberExpression(4);
		
		Expression exp1 = astf.makeInfixExpression(plus, one, two);
		Expression exp2 = astf.makeInfixExpression(plus, exp1, three);
		Expression exp3 = astf.makeInfixExpression(plus, exp2, four);
		
		Expression exp4 = astf.makeInfixExpression(div, vex, three);
		Expression exp5 = astf.makeInfixExpression(plus, exp4, two);
		Expression exp6 = astf.makeInfixExpression(mul, exp5, vex);
		
		Statement st1 = astf.makeDeclaration(x);
		Statement st2 = astf.makeAssignment(x, exp3);
		Statement st3 = astf.makeAssignment(x, exp6);
		
		Statement seq1 = astf.makeSequence(st1, st2);
		Statement seq2 = astf.makeSequence(seq1, st3);
		
		assertEquals("var x; x = 1 + 2 + 3 + 4; x = x / 3 + 2 * x;", seq2.textRepresentation());
	}
	
}
