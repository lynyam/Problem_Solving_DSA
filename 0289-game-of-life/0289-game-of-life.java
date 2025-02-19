class Solution {
	public void gameOfLife(int[][] board) {
		int m = board.length;
		int n = board[0].length;
		int[][] copyBoard = new int[m][n];
        int i = 0, j = 0;
        while (i < m) {
            j = 0;
            while (j < n) {
                copyBoard[i][j] = board[i][j];
                board[i][j] = 0;
                j++;
            }
            i++;
        }
		int[][] neighbors = new int[][] {{0, 1}, {1, 0}, 
                                         {1, 1}, {1, -1}, 
                                         {-1, 1}, {-1, -1}, 
                                         {0, -1}, {-1, 0}};
		i = j = 0;
		while (i < m) {
			j = 0;
			while (j < n) {
				int live = 0;
				int cell = copyBoard[i][j];
				for (int[] neighbor : neighbors) {
					int x = i + neighbor[0];
					int y = j + neighbor[1];
					if (x >= 0 && x < m && y >= 0 && y < n)
						live += (copyBoard[x][y] == 1 ?  1 : 0);
				}
                if ((cell == 1 && (live == 2 || live == 3)) || (cell == 0 && live == 3))
						board[i][j] = 1;
				j++;
			}
			i++;
		}
	}
}
