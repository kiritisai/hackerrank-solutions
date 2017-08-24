/*
 * Question URL: https://www.hackerrank.com/challenges/countingsort1
 */
package sorting;
import java.util.Scanner;

//TODO: Change this into a proper class like MergeSort and QuickSort later.
public class CountingSort {
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int N = 100; // 0-99 is the range specified in the problem.
		int n = in.nextInt();
		int[] frequencies = new int[N]; 
		for(int i=0; i<N; i++)
			frequencies[i] = 0;
		while(n>0)
		{
			int x = in.nextInt();
			frequencies[x]++;
			n--;
		}
		
		// Print out the numbers based on the frequencies array.
		// Since the frequencies are stored in order, this is the ordering of the numbers.
		for(int i=0; i<N; i++)
		{
			for(int j=0; j<frequencies[i]; j++)
				System.out.print(i+ " ");
		}
		System.out.println();
		in.close();
	}
}
