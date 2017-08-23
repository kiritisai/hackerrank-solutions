package search;

import java.util.Scanner;

public class HackerlandRadioTransmitter {
	public static int[] quickSort(int[] n)
	{
		return null;
	}
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] x = new int[n];
        for(int x_i=0; x_i < n; x_i++){
            x[x_i] = in.nextInt();
        }

        // Sort the elements using merge sort or quick sort
        // Since the number of elements are around 10**5, Quicksort would be better I guess.

        /*
         * Start from the left most.
         * At each house, check if there is any house within k reach.
         * Traverse until there is no house within 'k' distance and place a transmitter
         * at the last house.
         */
        
        in.close();
    }
}
