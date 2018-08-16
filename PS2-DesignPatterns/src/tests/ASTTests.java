package tests;
import ast.*;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Test Cases for ast package
 */

public class ASTTests {
	
	
	@Test
	/**
	 * Testing for the text representation of the set of statements: var x; x = 1 + 2;
	 */
	public void test1(){
		Variable x = new Variable("x");
		Expression one = new NumberExpression(1);
		Expression two = new NumberExpression(2);
		Operator plus = new Operator("+");
		Expression exp = new InfixExpression(plus, one, two);
		Statement decl = new Declaration(x);
		Statement assign = new Assignment(x, exp);
		Statement seq = new Sequence(decl, assign);
		assertEquals(seq.textRepresentation(), "var x; x = 1 + 2;");
	}
	
	@Test
	/**
	 * Testing for the text representation of the set of statements: var x; x = 1; var y; y = 3.05; y = x + 2.05;
	 */
	public void test2(){
		Variable x = new Variable("x");
		Variable y = new Variable("y");
		VariableExpression vex = new VariableExpression(x);
		Expression one = new NumberExpression(1);
		Expression two = new NumberExpression(2.05);
		Expression three = new NumberExpression(3.05);
		Operator plus = new Operator("+");
		
		Statement decl1 = new Declaration(x);
		Statement decl2 = new Declaration(y);
		Statement assign1 = new Assignment(x, one);
		Statement assign2 = new Assignment(y, three);
		
		Expression exp = new InfixExpression(plus, vex, two);
		Statement assign3 = new Assignment(y, exp);
		
		Statement seq = new Sequence(decl1, assign1);
		Statement seq1 = new Sequence(seq, decl2);
		Statement seq2 = new Sequence(seq1, assign2);
		Statement seq3 = new Sequence(seq2, assign3);
		assertEquals(seq3.textRepresentation(), "var x; x = 1; var y; y = 3.05; y = x + 2.05;");
	}
	
	@Test
	/**
	 * Testing for the text representation of the set of statements: var x; x = / * 6 3 2;
	 */
	public void test3(){
		Variable x = new Variable("x");
		Expression six = new NumberExpression(6);
		Expression three = new NumberExpression(3);
		Expression two = new NumberExpression(2);
		Operator div = new Operator("/");
		Operator mul = new Operator("*");
		
		Expression exp = new PrefixExpression(mul, six, three);
		Expression exp1 = new PrefixExpression(div, exp, two);
		
		Statement decl = new Declaration(x);
		Statement assign = new Assignment(x, exp1);
		Statement seq = new Sequence(decl, assign);
		assertEquals(seq.textRepresentation(), "var x; x = / * 6 3 2;");
	}
	
	@Test
	/**
	 * Testing for the text representation of the set of statements: var x; x = hello world!;
	 */
	public void test4(){
		Variable x = new Variable("x");
		Expression exp = new StringExpression("hello world!");

		Statement decl = new Declaration(x);
		Statement assign = new Assignment(x, exp);
		Statement seq = new Sequence(decl, assign);
		assertEquals(seq.textRepresentation(), "var x; x = hello world!;");
	}
	
	@Test
	/**
	 * Testing for the text representation of the set of statements: var x; x = 1 + 2 + 3 + 4; x = x / 3 + 2 * x;
	 */
	public void test5(){
		Variable x = new Variable("x");
		VariableExpression vex = new VariableExpression(x);
		Expression one = new NumberExpression(1);
		Expression two = new NumberExpression(2);
		Expression three = new NumberExpression(3);
		Expression four = new NumberExpression(4);
		Operator plus = new Operator("+");
		Operator div = new Operator("/");
		Operator mul = new Operator("*");
		
		Expression exp1 = new InfixExpression(plus, one, two);
		Expression exp2 = new InfixExpression(plus, exp1, three);
		Expression exp3 = new InfixExpression(plus, exp2, four);
		
		Expression exp4 = new InfixExpression(div, vex, three);
		Expression exp5 = new InfixExpression(plus, exp4, two);
		Expression exp6 = new InfixExpression(mul, exp5, vex);
		
		Statement st1 = new Declaration(x);
		Statement st2 = new Assignment(x, exp3);
		Statement st3 = new Assignment(x, exp6);
		
		Statement seq1 = new Sequence(st1, st2);
		Statement seq2 = new Sequence(seq1, st3);
		
		assertEquals(seq2.textRepresentation(), "var x; x = 1 + 2 + 3 + 4; x = x / 3 + 2 * x;");
	}
	
	
}
