import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * RangePrinter Class which implements the interface Range method
 * @author Veera Venkata Sasanka Uppu
 */
public class RangePrinter implements Range{

    @Override
    /**
     * Given two integers the function returns a list of odd integers in between
     * the two excluding the given two numbers
     * @param num1 is the lower limit in the range
     * @param num2 is the upper limit in the range
     * @return list of odd integers which fall in the range
     */
    public List<Integer> rangeCalculator(int num1, int num2) {

        List<Integer> temp = new ArrayList<>();
        
        // If the lower limit is > or = to the upper limit then no number exists in between them
        if(num1>=num2){
            return temp;
        }

        for (int i=num1+1;i<num2;i++)
        {
        		if(Math.abs(i)%2==1)
        		{
        				temp.add(i);
        		}
        }
        return temp;
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num1, num2;
        System.out.println("Enter lower limit in the range ie. num1");
        num1 = sc.nextInt();
        System.out.println("Enter upper limit in the range ie. num2");
        num2 = sc.nextInt();

        RangePrinter rp = new RangePrinter();
        List<Integer> result = rp.rangeCalculator(num1, num2);

        System.out.println(result.toString());
    }
}
