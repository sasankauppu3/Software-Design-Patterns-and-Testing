package hw4.question5;
/**
 * Sorter2 class which implements the Sorter interface and uses 
 * heapsort algorithm to sort a list
 * HeapSort code has been cited from geeksforgeeks.com web site
 * @author sasankauppu
 * @param <T> is generic type for the objects list
 */
public class Sorter2<T> implements Sorter {
 
	/**
	 * To heapify a subtree rooted with node i which is an index in arr[]. 
	 * @param list a generic array of any type
	 * @param n is size of heap
	 * @param i is the largest integer
	 */
    void heapify(Comparable[] list, int n, int i)
    {
        int largest = i;  // Initialize largest as root
        int l = 2*i + 1;  // left = 2*i + 1
        int r = 2*i + 2;  // right = 2*i + 2
 
        // If left child is larger than root
        if (l < n && comparator(list[largest],list[l]))
            largest = l;
 
        // If right child is larger than largest so far
        if (r < n && comparator(list[largest],list[r]))
            largest = r;
 
        // If largest is not root
        if (largest != i)
        {
            Comparable swap = list[i];
            list[i] = list[largest];
            list[largest] = swap;
 
            // Recursively heapify the affected sub-tree
            heapify(list, n, largest);
        }
    }
    
    /**
     * comparator is a function which compares two comparable objects 
     * @param f first comparable object
     * @param s second comparable object
     * @return True if f<s else false
     */
    public Boolean comparator(Comparable f,Comparable s)
    {
    		if(f==null && s==null)
    		{
    			return true;
    		}
    		else if(f==null)
    		{
    			return true;
    		}
    		else if(s==null)
    		{
    			return false;
    		}
		return f.compareTo(s)<0;
    }
    
    /**
	 * Main function that sorts arr[l..r] using heapify()
	 * @param list a generic array of any type which needs to be sorted
	 */
	public void sort(Comparable[] list) {
		int n = list.length;
		 
        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(list, n, i);
 
        // One by one extract an element from heap
        for (int i=n-1; i>=0; i--)
        {
            // Move current root to end
            Comparable temp = list[0];
            list[0] = list[i];
            list[i] = temp;
 
            // call max heapify on the reduced heap
            heapify(list, i, 0);
        }
	}
	
}
