/*
 * Question URL: https://www.hackerrank.com/challenges/the-grid-search
 */
package algorithmImplementation;

import java.util.Scanner;

public class GridSearch {
	/*
	 * Returns -1 if 'small' is not in 'large'
	 * Else, returns the index of the first occurance of 'small'.
	 */
	public static int[] substring_index(String large, String small)
	{
		// Instead of returning a single int, returning an array would be better.
		// To handle multiple substring occurrences.
		int[] result = new int[large.length()];
		// Fill the result elements with -1s
		int result_i=0;
		for(result_i=0; result_i<result.length; result_i++)
			result[result_i] = -1;

		result_i=0;
		for(int i=0; i<=large.length()-small.length(); i++)
		{
			//System.out.println(large.substring(i, i+small.length()));
			if(large.substring(i, i+small.length()).equals(small))
				result[result_i++] = i;
		}
		return result;
	}	
	
	public static boolean check_pattern(String[] G, String[] P, int start_row, int start_column)
	{
		/*
		 * Returns True if the pattern P is in G as per start_row and start_column
		 * Else returns False.
		 */
		// Check if the remaining rows match up
		boolean result = true;
		int p_column_length = P[0].length();
		for(int i=start_row; i<start_row+P.length; i++)
		{
			//System.out.println(G[i].substring(start_column, start_column+p_column_length) + ": " + P[i-start_row]);
			if(!G[i].substring(start_column, start_column+p_column_length).equals(P[i-start_row]))
				result = false;
		}
		return result;
	}

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int R = in.nextInt();
            int C = in.nextInt();
            String[] G = new String[R];
            for(int G_i=0; G_i < R; G_i++){
                G[G_i] = in.next();
            }
            int r = in.nextInt();
            int c = in.nextInt();
            String[] P = new String[r];
            for(int P_i=0; P_i < r; P_i++){
                P[P_i] = in.next();
            }
            
         
            int test_column, test_row;
            boolean result = false;
            for(int G_i=0; G_i<G.length; G_i++)
            {
            	int[] test_columns = substring_index(G[G_i], P[0]);
            	for(int test_i=0; test_i<test_columns.length; test_i++)
            	{
            		test_column = test_columns[test_i];
            		if(test_column != -1 && G.length - G_i >= P.length)
            		{
            			test_row = G_i;
            			if(check_pattern(G, P, test_row, test_column))
            			{
            				result = true;
            				break;
            			}
            		}
            	}
            	if(result)
            		break;
            }
            
            if(result)
            	System.out.println("YES");
            else
            	System.out.println("NO");
        }
    }
}
