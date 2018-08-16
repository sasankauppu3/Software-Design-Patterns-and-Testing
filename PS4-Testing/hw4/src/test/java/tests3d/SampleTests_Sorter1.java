package tests3d;

/**
 * Test suite to be used in CS5500 Homework 4.
 */
 
import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import hw4.question5.Sorter1;
import tests.Person;


public class SampleTests_Sorter1 {
  
    /**
     * Method for creating a sorter. Modify this to use your own sorter.
     * @return
     */
    private static <T extends Comparable<T>> Sorter1<T> createSorter(){
      return new Sorter1<T>();
    }
  
  // -----------------------------------------------
  // sort a list with one String element
  
  @Test
  public void testOneElement(){ 
    Sorter1<String> sorter = createSorter();
    String[] animals = { "dog" };
    sorter.sort(animals);
    String[] sorted = { "dog" };
    assertArrayEquals(animals, sorted);
  }
   
  // -----------------------------------------------
  // sort a list with multiple String elements
  
  @Test
  public void testMultipleElements(){
    Sorter1<String> sorter = createSorter();
    String[] animals = { "dog", "cat", "pig", "cow", "horse" };
    sorter.sort(animals);
    String[] sorted = { "cat", "cow", "dog", "horse", "pig" };
    assertArrayEquals(animals, sorted);
  }
   
  // -----------------------------------------------
  // sort a list with ints
  
  @Test
  public void testints(){
    Sorter1<Integer> sorter = createSorter();
    Integer[] ints = { 1, 4, 5, 3 };
    sorter.sort(ints);
    Integer[] sorted = { 1, 3, 4, 5 };
    assertArrayEquals(ints, sorted);
  }
   
  // -----------------------------------------------
  // sort an empty list (of strings)
  
  @Test
  public void testEmpty(){
    Sorter1<String> sorter = createSorter();
    String[] animals = {  };
    sorter.sort(animals);
    String[] sorted = {  };
    assertArrayEquals(animals, sorted);
  }
  
  // -----------------------------------------------
  // sort list containing one element of a user-defined type
  
  @Test
  public void testOneUserDefinedType(){
    Sorter1<Person> sorter = createSorter();
    Person[] people = { new Person("Joe") };
    sorter.sort(people);
    Person[] sorted = { new Person("Joe") };
    assertArrayEquals(people, sorted);
  }
   
  // -----------------------------------------------
  // sort a very large list
  
  @Test
  public void testVeryLarge(){
    Sorter1<Integer> sorter = createSorter();
    int VERY_LARGE = 10000000;
    Integer[] numbers = new Integer[VERY_LARGE];
    Integer[] sorted = new Integer[VERY_LARGE];
    for (int i=0; i < VERY_LARGE; i++){
      sorted[i] = i;
      numbers[VERY_LARGE-i-1] = i;
    }
    sorter.sort(numbers); 
    assertArrayEquals(numbers, sorted);
  }
   
  // -----------------------------------------------
  // sort a list with a null element
  
  @Test
  public void testNull(){ 
    Sorter1<Integer> sorter = createSorter();
    Integer[] numbers = { 6, 2, null, 8 }; 
    Integer[] sorted =  { null, 2, 6, 8 };
    sorter.sort(numbers); 
    assertArrayEquals(numbers, sorted);
  }
  
  @Test
  //TEST THAT COVERS 100% STATEMENT AND BRANCH COVERAGE
  //test for integer list with multiple nulls
  public void testMultipleNullInteger(){ 
    Sorter1<Integer> sorter = createSorter();
    Integer[] list = { 2, 1,null, null, 3 }; 
    Integer[] sortedlist =  { null, null, 1, 2, 3 };
    sorter.sort(list); 
    assertArrayEquals(list, sortedlist);
  }
  
  
  
  
}


