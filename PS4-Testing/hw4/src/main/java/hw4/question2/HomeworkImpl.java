package hw4.question2;
/**
 * HomeworkImpl Class implements Homework Interface for problem 2 which has the functions 
 * implemented such as: square of a number, squareroot of a number, factorial of a number
 * @author sasankauppu
 */
public class HomeworkImpl implements Homework{

	/**
	 * function that produces the square of an input number n
	 * @param n: an integer 
	 * @return the square of n
	 */
	public int sqr(int n) {
		if(n>=Integer.MAX_VALUE)
			return (int) Double.NaN;
		return n*n;
	}

	/**
	 * function to produces the square root of a non-negative input number n
	 * @param n: an integer
	 * @return the square root of n 
	 */
	public double sqrt(int n) {
		if(n<0)
			return Double.NaN;
		return Math.sqrt(n);
	}

	/**
	 * function that produces n!
	 * @param n:an integer
	 * @return factorial of n if n>=0 else NaN
	 */
	public int factorial(int n) {
		if(n<0 || n>Integer.MAX_VALUE)
			return (int) Double.NaN;
		
		int fact=1;  
		for(int i=1;i<=n;i++){    
		      fact=fact*i;    
		} 
		return fact;
	}

}
