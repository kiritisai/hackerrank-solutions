/*
 * Question URL: https://www.hackerrank.com/challenges/sherlock-and-cost
 * Yet another program which doesn't require any sort of dynamic programming
 */
package dynamicProgramming;
import java.util.Scanner;

public class SherlockAndCost {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int z=0; z<T; z++)
		{
			int N = in.nextInt();
			int[] B = new int[N];
			for(int i=0; i<N; i++)
				B[i] = in.nextInt();
			
			long max_S = 0;
			for(int i=1; i<N; i++)
				max_S += Math.max(B[i], B[i-1]);
			
			max_S -= N-1;
			System.out.println(max_S);
		}
		
		
		in.close();
	}

}
