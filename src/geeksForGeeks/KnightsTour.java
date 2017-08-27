/*
 * GFG URL: http://www.geeksforgeeks.org/backtracking-set-1-the-knights-tour-problem/
 */
package geeksForGeeks;

public class KnightsTour {
	/*
	 * Returns true if its safe to take (x_move, y_move) from (x,y) on a board of size N
	 */
	private static boolean isSafe(int x, int y, int x_move, int y_move, int[][] board){
		int new_x = x+x_move;
		int new_y = y+y_move;
		int N = board[0].length;
		
		if(new_x>=0 && new_x<N && new_y>=0 && new_y<N && board[new_x][new_y] == -1)
			return true;
		else
			return false;
	}
	
	/*
	 * This util function checks the feasibility of each step and
	 * makes recursive calls or returns peacefully.
	 * moves: How many moves have been already made
	 */
	private static boolean knightTourUtil(int x, int y, int moves, int[] x_moves, int[] y_moves, int[][] board)
	{
		int N = board[0].length;
		// If all the moves are completed, return true
		if(moves == N*N)
			return true;
		int N_moves = x_moves.length; // A knight can make 8 moves
		// Try each move's possibility
		for(int i=0; i<N_moves; i++)
		{
			if(isSafe(x,y,x_moves[i], y_moves[i], board))
			{
				// Make the move
				int new_x = x+x_moves[i];
				int new_y = y+y_moves[i];
				board[new_x][new_y] = moves + 1; // Registering that the move has been made
				boolean next_move = knightTourUtil(new_x, new_y, moves + 1, x_moves, y_moves, board);
				if(next_move)
					return true;
				else
					board[new_x][new_y] = -1; //backtrack
			}
		}
		// Since none of the moves worked out
		return false;
	}
	
	public static void printBoard(int[][] board)
	{
		int N = board[0].length;
		for(int i=0; i<N; i++)
		{
			for(int j=0; j<N; j++)
				System.out.format("%2d ", board[i][j]);
			System.out.println();
		}
	}

	public static void main(String[] args)
	{
		int N = 8; // Size of the chess board
		int[][] board = new int[N][N];
		
		// Initialize everything to -1
		for(int i=0; i<N; i++)
			for(int j=0; j<N; j++)
				board[i][j] = -1;
		
		// Defining the moves a Knight could take on the chess board.
		int[] x_moves = {-2, -2, -1, -1, 1, 1, 2, 2};
		int[] y_moves = {1, -1, 2, -2, 2, -2, 1, -1};
		
		boolean result = knightTourUtil(0, 0, 0, x_moves, y_moves, board);
		if(result)
		{
			System.out.println("SUCCESS!!");
			printBoard(board);
		}
		else
			System.out.println("Yayy, I get to debug!");
	}
}
