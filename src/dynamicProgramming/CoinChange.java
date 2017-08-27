package dynamicProgramming;

import java.util.Scanner;

public class CoinChange {
    static long getWays(long n, long[] c, int m, long[][] table){
    	// m : No.of coins to consider
    	// Either have at least 1 nth coin or no nth coin
    	if(n == 0)
    		return 1;
    	if(m==0 || n<0)
    		return 0;
    	
    	if(table[(int)n][m] != -1)
    		return table[(int)n][m];

    	int start_coin = c.length - m;
    	long result = getWays(n - c[start_coin], c, m, table) + getWays(n, c, m-1, table);
    	table[(int) n][m] = result;
    	return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        long[][] table = new long[n+1][m+1];

        // Initializing the memoization table with -1s
        for(int i=0; i<n+1; i++)
        	for(int j=0; j<m+1; j++)
        		table[i][j] = -1;

        long[] c = new long[m];
        for(int c_i=0; c_i < m; c_i++){
            c[c_i] = in.nextLong();
        }
        // Print the number of ways of making change for 'n' units using coins having the values given by 'c'
        long ways = getWays(n, c, m, table);
        System.out.println(ways);
        
        // Always have to close this because of the Eclipse warning :P
        in.close();
    }
}
