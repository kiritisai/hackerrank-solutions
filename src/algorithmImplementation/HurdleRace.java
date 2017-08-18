/*
 * Question URL: https://www.hackerrank.com/challenges/the-hurdle-race
 */
package algorithmImplementation;

import java.util.Scanner;

public class HurdleRace {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] height = new int[n];
        for(int height_i=0; height_i < n; height_i++){
            height[height_i] = in.nextInt();
        }
        
        // Find maximum hurdle height
        int max_hurdle_height = 0;
        for(int height_i=0; height_i < n; height_i++){
        	if(height[height_i] > max_hurdle_height)
        		max_hurdle_height = height[height_i];
        }
        
        int result;
        if(k >= max_hurdle_height)
        	result = 0;
        else
        	result = max_hurdle_height-k;
        
        System.out.println(result);
    }
}
