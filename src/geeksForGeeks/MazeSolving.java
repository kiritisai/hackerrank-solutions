/*
 * GFG URL: http://www.geeksforgeeks.org/backttracking-set-2-rat-in-a-maze/
 */
package geeksForGeeks;
import java.util.Scanner;

public class MazeSolving {
	private class Move{
		public int x;
		int y;
		public Move(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	private static boolean isSafe(int x, int y, Move move, int[][] maze)
	{
		int N = maze[0].length;
		int new_x = x + move.x;
		int new_y = y + move.y;
		
		// If it's not out of limits and no obstacle is present.
		if(new_x>=0 && new_x<N && new_y>=0 && new_y<N && maze[new_x][new_y] != 0)
			return true;
		else
			return false;
	}
	
	private static boolean mazeUtil(int x, int y, Move[] moves, int[][] maze, int[][] solution) {
		int N_moves = moves.length;
		int N = maze[0].length;
		
		// Reached destination
		if(x == N-1 && y == N-1)
			return true;
		
		// Try each move from the current location
		for(int i=0; i<N_moves; i++)
		{
			if(isSafe(x, y, moves[i], maze))
			{
				// make the move
				int new_x = x + moves[i].x;
				int new_y = y + moves[i].y;
				solution[new_x][new_y] = 1;
				boolean next_move = mazeUtil(new_x, new_y, moves, maze, solution);
				if(next_move)
					return true;
				else
					solution[new_x][new_y] = 0; // backtrack
			}
		}
		return false;
	}
	
	private static void printSolution(int[][] solution)
	{
		int N = solution[0].length;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(solution[i][j]);
			}
			System.out.println();
		}
	}
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int N = in.nextInt(); // Size of the maze
		int[][] maze = new int[N][N];
		int[][] solution = new int[N][N];
		// Initialize with 0s
		for(int i=0; i<N; i++)
			for(int j=0; j<N; j++)
				solution[i][j] = 0;
		
		// Starting position
		solution[0][0] = 1;

		// Scan the maze
		for(int i=0; i<N; i++)
			for(int j=0; j<N; j++)
				maze[i][j] = in.nextInt();
		
		// Outline the possible moves
		MazeSolving m = new MazeSolving();
		// TIL: When using an internal class, an instantiation of the main class is required.
		Move forward = m.new Move(1, 0);
		Move down = m.new Move(0, 1);
		Move[] moves = {forward, down};
		
		boolean result = mazeUtil(0, 0, moves, maze, solution);
		if(result)
		{
			System.out.println("SUCCESS!!");
			printSolution(solution);
		}
		else
			System.out.println("YAYY, Debugging time");
		in.close();
	}

}
