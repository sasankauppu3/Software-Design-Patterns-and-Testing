package tests2;

/**
 * Test suite to be used in CS5500 Homework 4.
 */
 
import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import hw4.question5.Sorter2;


public class Sorter2Tests {
  
    /**
     * Method for creating a sorter. Modify this to use your own sorter.
     * @return
     */
    private static <T extends Comparable<T>> Sorter2<T> createSorter(){
      return new Sorter2<T>();
    }
  
    //test an Empty Integer list
    @Test
    public void testEmptyIntegerElement(){ 
      Sorter2<Integer> sorter = createSorter();
      Integer[] list = { };
      sorter.sort(list);
      Integer[] sortedlist = { };
      assertArrayEquals(list, sortedlist);
    }
    
    //test an Empty String list
    @Test
    public void testEmptyStringElement(){ 
      Sorter2<String> sorter = createSorter();
      String[] list = { };
      sorter.sort(list);
      String[] sortedlist = { };
      assertArrayEquals(list, sortedlist);
    }
    
    //test one Integer list
    @Test
    public void testOneIntegerElement(){ 
      Sorter2<Integer> sorter = createSorter();
      Integer[] list = { 2 };
      sorter.sort(list);
      Integer[] sortedlist = { 2 };
      assertArrayEquals(list, sortedlist);
    }
    
    //test one Double list
    @Test
    public void testOneDoubleElement(){ 
      Sorter2<Double> sorter = createSorter();
      Double[] list = { 2.365 };
      sorter.sort(list);
      Double[] sortedlist = { 2.365 };
      assertArrayEquals(list, sortedlist);
    }
    
    //test two Integer list
    @Test
    public void testTwoIntegerElements(){ 
      Sorter2<Integer> sorter = createSorter();
      Integer[] list = { 3, 2};
      sorter.sort(list);
      Integer[] sorted = { 2, 3};
      assertArrayEquals(list, sorted);
    }
   
    //test two String list
    @Test
    public void testTwoStringElements(){ 
      Sorter2<String> sorter = createSorter();
      String[] list = { "ab","aa"};
      sorter.sort(list);
      String[] sorted = { "aa", "ab"};
      assertArrayEquals(list, sorted);
    }
    
    //test multiple integers list
    @Test
    public void testMultipleIntegerElements(){ 
      Sorter2<Integer> sorter = createSorter();
      Integer[] list = { 7, 2, 6, 1, 9, 3 };
      sorter.sort(list);
      Integer[] sortedlist = { 1, 2, 3, 6, 7, 9};
      assertArrayEquals(list, sortedlist);
    }
    
    //test multiple Negative Integer list
    @Test
    public void testMultipleNegativeIntegerElements(){ 
      Sorter2<Integer> sorter = createSorter();
      Integer[] list = { -7, -2, -6, -1, -9, -3 };
      sorter.sort(list);
      Integer[] sortedlist = { -9,-7,-6,-3,-2,-1};
      assertArrayEquals(list, sortedlist);
    }
    
    @Test
    //test multiple String list
    public void testMultipleStringElements(){
      Sorter2<String> sorter = createSorter();
      String[] words = { "aab", "abc", "aaa", "ade", "aad" };
      sorter.sort(words);
      String[] sortedlist = { "aaa", "aab", "aad", "abc", "ade" };
      assertArrayEquals(words, sortedlist);
    }
    
    @Test
    //test multiple Negative Float list
    public void testMultipleNeagtiveFloatElements(){
      Sorter2<Float> sorter = createSorter();
      Float[] words = { 3.1f,-2.4f,5.6f,-4.7f };
      sorter.sort(words);
      Float[] sortedlist = { -4.7f,-2.4f,3.1f,5.6f};
      assertArrayEquals(words, sortedlist);
    }
    
    @Test
    //test multiple  Double list
    public void testMultipleDoubleElements(){
      Sorter2<Double> sorter = createSorter();
      Double[] words = { 3.1,2.4,5.6,4.7 };
      sorter.sort(words);
      Double[] sortedlist = { 2.4,3.1,4.7,5.6};
      assertArrayEquals(words, sortedlist);
    }

    @Test
    //test all duplicate Integer list
    public void testDuplicateOnlyIntegerElements(){ 
      Sorter2<Integer> sorter = createSorter();
      Integer[] list = { 3, 3, 3, 3 };
      sorter.sort(list);
      Integer[] sortedlist = { 3, 3, 3, 3};
      assertArrayEquals(list, sortedlist);
    }
    
    @Test
    //test multiple duplicates Integer list
    public void testMultipleDuplicateIntegerElements(){ 
      Sorter2<Integer> sorter = createSorter();
      Integer[] list = { 7, 2, 7, 1, 1, 3 };
      sorter.sort(list);
      Integer[] sortedlist = { 1, 1, 2, 3, 7, 7};
      assertArrayEquals(list, sortedlist);
    }
  
    @Test
    //test multiple duplicates string list
    public void testMultipleDuplicateStringElements(){ 
      Sorter2<String> sorter = createSorter();
      String[] list = { "ab","aa", "ac","ab","aa" };
      sorter.sort(list);
      String[] sortedlist = { "aa","aa","ab","ab","ac"};
      assertArrayEquals(list, sortedlist);
    }
  
    @Test
    //test multiple duplicates Double list
    public void testMultipleDuplicateDoubleElements(){ 
    	Sorter2<Double> sorter = createSorter();
        Double[] words = { 3.1,2.4,5.6,2.4,4.7,3.1 };
        sorter.sort(words);
        Double[] sortedlist = { 2.4,2.4,3.1,3.1,4.7,5.6};
        assertArrayEquals(words, sortedlist);
    }
   
  
  @Test
  //test Large integer list
  public void testLargeIntegerInput(){
    Sorter2<Integer> sorter = createSorter();
    int n = 1000000;
    Integer[] list = new Integer[n];
    Integer[] sortedlist = new Integer[n];
    for (int i=0; i < n; i++){
      sortedlist[i] = i;
      list[n-i-1] = i;
    }
    sorter.sort(list); 
    assertArrayEquals(list, sortedlist);
  }
  
  @Test
  //test Large Double list
  public void testLargeDoubleInput(){
    Sorter2<Double> sorter = createSorter();
    int n = 1000000;
    Double[] list = new Double[n];
    Double[] sortedlist = new Double[n];
    for (int i=0; i < n; i++){
      sortedlist[i] = (double) i+0.001;
      list[n-i-1] = (double) i+0.001;
    }
    sorter.sort(list); 
    assertArrayEquals(list, sortedlist);
  }
   

  @Test
  //test Integer list with null
  public void testNullInteger(){ 
    Sorter2<Integer> sorter = createSorter();
    Integer[] list = { 2, 1, null, 3 }; 
    Integer[] sortedlist =  { null, 1, 2, 3 };
    sorter.sort(list); 
    assertArrayEquals(list, sortedlist);
  }
   
  @Test
  //test string list with null
  public void testNullString(){ 
    Sorter2<String> sorter = createSorter();
    String[] list = { "ab", "aa", "ac", null }; 
    String[] sortedlist =  { null, "aa","ab","ac" };
    sorter.sort(list); 
    assertArrayEquals(list, sortedlist);
  }
  
  @Test
  //test a userdefined type list
  public void testUserDefinedTypeInteger(){
    Sorter2<TestClass> sorter = createSorter();
    TestClass[] list = { new TestClass(3), new TestClass(2),new TestClass(1)};
    sorter.sort(list);
    TestClass[] sortedlist = { new TestClass(1),new TestClass(2),new TestClass(3) };
    assertArrayEquals(list, sortedlist);
  }
  
  @Test
//test a userdefined type list with duplicates
  public void testUserDefinedTypeIntegerWithDuplicates(){
    Sorter2<TestClass> sorter = createSorter();
    TestClass[] list = { new TestClass(1),new TestClass(3), new TestClass(2),new TestClass(1),new TestClass(2)};
    sorter.sort(list);
    TestClass[] sortedlist = { new TestClass(1),new TestClass(1),new TestClass(2),new TestClass(2),new TestClass(3) };
    assertArrayEquals(list, sortedlist);
  }
  
  public class TestClass implements Comparable<TestClass>
  {
  	Integer val;
  	Integer val2;
  	public TestClass(Integer num)
  	{
  		val=num;
  	}
  	@Override
  	public int hashCode() {
  		final int prime = 31;
  		int result = 1;
  		result = prime * result + ((val == null) ? 0 : val.hashCode());
  		return result;
  	}
  	@Override
  	public boolean equals(Object obj) {
  		if (this == obj)
  			return true;
  		if (obj == null)
  			return false;
  		if (getClass() != obj.getClass())
  			return false;
  		TestClass other = (TestClass) obj;
  		if (val == null) {
  			if (other.val != null)
  				return false;
  		} else if (!val.equals(other.val))
  			return false;
  		return true;
  	}
  	
  	public int compareTo(TestClass o) {
  		// TODO Auto-generated method stub
  		return val.compareTo(o.val);
  	}
	 
  	
  }
  
}


