package tests3;
import ast3.*;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

/**
 * Test Cases for ast2 package
 */

public class AST3Tests {
	
	@Test
	/**
	 * Testing for the text representation of the set of statements: var x; x = 1 + 2; x = / x 2;
	 * and var y; y = hello;"
	 */
	public void test1(){
		AstFactory astf1 = new AstFactory();
		AstFactory astf2 = new AstFactory();
		
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
		assertEquals(seq2.textRepresentation(), "var x; x = 1 + 2; x = / x 2;");
		assertEquals(seq3.textRepresentation(), "var y; y = hello;");
		assertEquals(astf1.getReport(), Arrays.asList(2, 0, 1, 1, 1, 2, 2, 1) );
		astf1.report();
		assertEquals(astf2.getReport(), Arrays.asList(0, 1, 0, 0, 0, 1, 1, 1) );
		astf2.report();
	}
	
	@Test
	/** Testing for the text representation of the set of statements: var x; x = 1 + 2;
	*/
	public void test2(){
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
	public void test3(){
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
	public void test4(){
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
	public void test5(){
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
	public void test6(){
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
	
	@Test
	/**
	 * Testing for the text representation of the set of statements: var x; var y; x = 1 + 2; x = / x 2; y = hello;
	 */
	public void test7(){
		AstFactory astf = new AstFactory();
		Variable x = new Variable("x");
		Variable y = new Variable("y");
		Operator plus = new Operator("+");
		Operator div = new Operator("/");
		
		Expression vex = astf.makeVariableExpression(x);
		Expression one = astf.makeNumberExpression(1);
		Expression two = astf.makeNumberExpression(2);
		
		Expression exp1 = astf.makeInfixExpression(plus, one, two);
		Expression exp2 = astf.makePrefixExpression(div, vex, two);
		Expression exp3 = astf.makeStringExpression("hello");
		
		Statement st1 = astf.makeDeclaration(x);
		Statement st2 = astf.makeDeclaration(y);
		Statement st3 = astf.makeAssignment(x, exp1);
		Statement st4 = astf.makeAssignment(x, exp2);
		Statement st5 = astf.makeAssignment(y,exp3);
		
		Statement seq1 = astf.makeSequence(st1, st2);
		Statement seq2 = astf.makeSequence(seq1, st3);
		Statement seq3 = astf.makeSequence(seq2, st4);
		Statement seq4 = astf.makeSequence(seq3, st5);
		assertEquals(seq4.textRepresentation(), "var x; var y; x = 1 + 2; x = / x 2; y = hello;");
		assertEquals(astf.getReport(), Arrays.asList(2, 1, 1, 1, 1, 4, 3, 2) );
	}
	
	
}
