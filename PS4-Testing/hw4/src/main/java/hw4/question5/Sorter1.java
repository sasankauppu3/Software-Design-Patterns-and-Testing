package hw4.question5;
/**
 * Sorter1 class which implements the Sorter interface and uses 
 * mergesort algorithm to sort a list 
 * MergeSort code has been cited from geeksforgeeks.com web site
 * @author sasankauppu
 * @param <T> is generic type for the objects list
 */
public class Sorter1<T> implements Sorter{
	
	/**
	 * Main function that sorts arr[l..r] using merge()
	 * @param arr a generic array of any type
	 * @param l left continuing index of the array in merge sort process
	 * @param r right continuing index of the array in merge sort process
	 */
    public void sort(Comparable[] list, int l, int r) {
        if (l < r)
        {
            // Find the middle point
            int m = (l+r)/2;
 
            // Sort first and second halves
            sort(list, l, m);
            sort(list , m+1, r);
 
            // Merge the sorted halves
            merge(list, l, m, r);
        }
    }


    /**
     * Function that Merges two subarrays of arr[]
     * @param list a generic array of any type
     * @param l specifies the sub array index which is l to m
     * @param m specifies the middle point of array
     * @param r specifies the sub array index which is m+1 to r 
     */
    public void merge(Comparable[] list, int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
  
        /* Create temp arrays */
        Comparable[] LArr = new Comparable [n1];
        Comparable RArr[] = new Comparable [n2];
 
        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i)
            LArr[i] = list[l + i];
        for (int j=0; j<n2; ++j)
            RArr[j] = list[m + 1+ j];
 
 
        /* Merge the temp arrays */
 
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
 
        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2)
        {
        	    if (comparator(LArr[i],RArr[j]))
            {
                list[k] = LArr[i];
                i++;
            }
            else
            {
                list[k] = RArr[j];
                j++;
            }
            k++;
        }
 
        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            list[k] = LArr[i];
            i++;
            k++;
        }
 
        /* Copy remaining elements of R[] if any */
        while (j < n2)
        { 
            list[k] = RArr[j];
            j++;
            k++;
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
     * Function that initiates sort method by splitting it for the first run
     * @param list: a generic list of any type which needs to be sorted
     */
	public void sort(Comparable[] list) {
        sort(list, 0, list.length-1);
	}

}
