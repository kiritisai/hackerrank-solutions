package algorithmImplementation;

import java.util.Scanner;

public class CavityMap {
	public static void print_map(int[][] map, int n)
	{
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<n; j++)
			{
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void print_result(int[][] map, boolean[][] canBeCavity, int n)
	{
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<n; j++)
			{
				if(canBeCavity[i][j])
					System.out.print('X');
				else
					System.out.print(map[i][j]);
			}
			if(i != n-1)
				System.out.println();
		}
	}

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] map = new int[n][n];
        /*String[] grid = new String[n];
        for(int grid_i=0; grid_i < n; grid_i++){
            grid[grid_i] = in.next();
        }*/
        
        for(int i=0; i<n; i++)
        {
        	String row = in.next();
        	for(int j=0; j<row.length(); j++)
        		map[i][j] = row.charAt(j) - '0';
        }
        
        // Checking the input
        //print_map(map, n);
        
        // Taking the input in integers would be better I guess.
        boolean[][] canBeCavity = new boolean[n][n];
        for(int i=0; i<n; i++)
        {
        	for(int j=0; j<n; j++)
        	{
        		// Borders cannot be cavities.
        		if(i==0 || i==n-1 || j==0 || j==n-1)
        			canBeCavity[i][j] = false;
        		else
        			canBeCavity[i][j] = true;
        	}
        }        
        
        // For values that are not on the border and canBeCavity=true
        // Check if it's a cavity. If yes, mark it's neighbours as false for canBeCavity
        // If no, just mark the current position as false.
        for(int i=1; i<n-1; i++)
        {
        	for(int j=1; j<n-1; j++)
        	{
        		if(map[i][j] > map[i-1][j] && map[i][j]>map[i+1][j] &&
        				map[i][j]>map[i][j+1] && map[i][j]>map[i][j-1])
        		{
        			// Marking neighbours false
        			canBeCavity[i-1][j] = false;
        			canBeCavity[i+1][j] = false;
        			canBeCavity[i][j+1] = false;
        			canBeCavity[i][j-1] = false;
        		}
        		else
        			canBeCavity[i][j] = false;
        	}
        }        
        print_result(map, canBeCavity, n);
    }
}
