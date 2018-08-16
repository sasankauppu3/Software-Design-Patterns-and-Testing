import java.util.List;

/**
 * Interface which consists method signature for rangePrint function
 */
public interface Range {
    /**
     * Given two integers the function returns a list of odd integers in between
     * the two excluding the given two numbers
     * @param num1 is the lower limit in the range
     * @param num2 is the upper limit in the range
     * @return list of odd integers which fall in the range
     */
    public List<Integer> rangeCalculator(int num1, int num2);
}
