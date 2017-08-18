package algorithmImplementation;

import java.util.Scanner;

public class ClimbingLeaderboard {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] scores = new int[n];
        for(int scores_i=0; scores_i < n; scores_i++){
            scores[scores_i] = in.nextInt();
        }
        int m = in.nextInt();
        int[] alice = new int[m];
        for(int alice_i=0; alice_i < m; alice_i++){
            alice[alice_i] = in.nextInt();
        }
        
        // Calculate the ranks array 
        int prev_score = scores[0];
        int rank = 1;
        int ranks[] = new int[n];
        for(int scores_i=0; scores_i<n; scores_i++)
        {
        	if(scores[scores_i] < prev_score)
        		rank++;
        	ranks[scores_i] = rank;
        	prev_score = scores[scores_i];
        }
        
        // Bottom up approach will have much less complexity
        int next_high_pos = n-1;
        for(int alice_i=0; alice_i<m; alice_i++)
        {
        	int alice_score = alice[alice_i];

        	// Go from alice_rank to above
        	while(next_high_pos >= 0 && alice_score >= scores[next_high_pos])
        		next_high_pos--;
        	
        	if(next_high_pos < 0)
        		System.out.println(1);
        	else
        		System.out.println(ranks[next_high_pos] + 1);
        }
        
        in.close();
    }
}
