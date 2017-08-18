/*
 * Question URL: https://www.hackerrank.com/challenges/big-sorting
 */
package sorting;

import java.util.Scanner;

public class BigSorting {
	public static boolean isGreater(String s1, String s2)
	{
		/*
		 * Returns true if s1 > s2
		 * else, false
		 */
		if(s1.length() > s2.length())
			return true;
		else if(s1.length() < s2.length())
			return false;
		else
		{
			for(int i=0; i<s1.length(); i++)
			{
				if(s2.charAt(i) > s1.charAt(i))
					return false;
			}
		}
		return true;
	}
	
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] unsorted = new String[n];
        for(int unsorted_i=0; unsorted_i < n; unsorted_i++){
            unsorted[unsorted_i] = in.next();
        }
        
        // Do Bubble sort over the numbers
        // Bubble sort is giving timeout, should use some merge sort or something
        for(int i=0; i<n; i++)
        {
        	for(int j=0; j<n; j++)
        	{
        		if(!isGreater(unsorted[i], unsorted[j]))
        		{
        			// Swap them
        			String temp = unsorted[i];
        			unsorted[i] = unsorted[j];
        			unsorted[j] = temp;
        		}
        	}
        }
        
        for(int i=0; i<n; i++)
        {
        	System.out.println(unsorted[i]);
        }
    }	

}
