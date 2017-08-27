/*
 * GFF URL: http://www.geeksforgeeks.org/backttracking-set-4-subset-sum/
 * This program is to check if there is a required subset in the given set and print it.
 * To return all possibilities, there should be a slight change in the backtracking algo (Refer the above link)
 * Shit!! I've just realized that the coin change problem and the subset problem are one and the same. :/ 
 */
package geeksForGeeks;

import java.util.Scanner;

public class SubsetSum {
	/*
	 * Returns number of elements==True in chosen.
	 */
	private static int num_chosen(boolean[] chosen)
	{
		int count = 0;
		int length = chosen.length;
		for(int i=0; i<length; i++)
			if(chosen[i]) count++;
		return count;
	}

	private static boolean subsetUtil(int sum, int target, int[] set, boolean[] chosen)
	{
		if(sum == target)
			return true;
		// If there are no numbers left, return false
		if(num_chosen(chosen) == chosen.length)
			return false;
		
		int index = 0;
		// Try adding each unchosen number in  the set
		while(index < chosen.length)
		{
			// Search for an unchosen number
			while(index < chosen.length && chosen[index])
				index++;
			
			// If no unchosen number found
			if(index >= chosen.length)
				break;

			int new_number = set[index];
			// Check that sum doesn't exceed target on adding this number
			if(sum+new_number <= target)
			{
				chosen[index] = true;
				boolean isOkay = subsetUtil(sum+new_number, target, set, chosen);
				if(isOkay)
					return true;
				else
				{
					/*
					 * Interesting observation:
					 * There is no need to set chosen[index] = false, because failing here means,
					 * there was no solution when this number was considered. Hence, don't consider
					 * this number for the next stages. If you consider the number again, it'll lead
					 * to repetitive cases.
					 */
					//chosen[index] = false; // Backtrack and try with another number
					chosen[index] = true; // Backtrack is simply carrying forward with the remaining numbers
				}
			}
			index++; // Try with the next number in the set
		}
		return false;
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] set = new int[N];
		// Scan the input
		for(int i=0; i<N; i++)
			set[i] = sc.nextInt();
		
		// Scan the target
		int target = sc.nextInt();
		
		boolean[] chosen = new boolean[N];
		for(int i=0; i<N; i++)
			chosen[i] = false;
		boolean result = subsetUtil(0, target, set, chosen);
		if(result)
			System.out.println("Success!!");
		else
			System.out.println("Debug time!!");
	}

}
