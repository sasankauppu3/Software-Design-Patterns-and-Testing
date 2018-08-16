package hw4.question5;

/**
* Generic interface for sorting an array of elements in-place.
*/

public interface Sorter<T extends Comparable<T>> {
 void sort(T[] list);
}