package tests2;
import ast2.*;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Test Cases for ast2 package
 */

public class AST2Tests {
	
	
	@Test
	/**
	 * Testing for the text representation of the set of statements: var x; x = 1 + 2;
	 */
	public void test1(){
		AstFactory astf = new AstFactory();
		Variable x = new Variable("x");
		Operator plus = new Operator("+");
		
		Expression one = astf.makeNumberExpression(1);
		Expression two = astf.makeNumberExpression(2);
		Expression exp = astf.makeInfixExpression(plus, one, two);
		Statement decl = astf.makeDeclaration(x);
		Statement assign = astf.makeAssignment(x, exp);
		Statement seq = astf.makeSequence(decl, assign);
		assertEquals(seq.textRepresentation(), "var x; x = 1 + 2;");
	}
	
	@Test
	/**
	 * Testing for the text representation of the set of statements: var x; x = 1; var y; y = 3.05; y = x + 2.05;
	 */
	public void test2(){
		AstFactory astf = new AstFactory();
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
		assertEquals(seq3.textRepresentation(), "var x; x = 1; var y; y = 3.05; y = x + 2.05;");
	}
	
	@Test
	/**
	 * Testing for the text representation of the set of statements: var x; x = / * 6 3 2;
	 */
	public void test3(){
		AstFactory astf = new AstFactory();
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
		assertEquals(seq.textRepresentation(), "var x; x = / * 6 3 2;");
	}
	
	@Test
	/**
	 * Testing for the text representation of the set of statements: var x; x = hello world!;
	 */
	public void test4(){
		AstFactory astf = new AstFactory();
		Variable x = new Variable("x");
		Expression exp = astf.makeStringExpression("hello world!");

		Statement decl = astf.makeDeclaration(x);
		Statement assign = astf.makeAssignment(x, exp);
		Statement seq = astf.makeSequence(decl, assign);
		assertEquals(seq.textRepresentation(), "var x; x = hello world!;");
	}
	
	@Test
	/**
	 * Testing for the text representation of the set of statements: var x; x = 1 + 2 + 3 + 4; x = x / 3 + 2 * x;
	 */
	public void test5(){
		AstFactory astf = new AstFactory();
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
		
		assertEquals(seq2.textRepresentation(), "var x; x = 1 + 2 + 3 + 4; x = x / 3 + 2 * x;");
	}
	
	
}
