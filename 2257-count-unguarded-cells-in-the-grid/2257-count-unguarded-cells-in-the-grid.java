class Solution {
    Set<String> occupied;
    public int countUnguarded(int m, int n, int[][] gards, int[][] walls) {
	Set<String> blocks = new HashSet<>();
	for (int[] cell : gards)
		blocks.add(cell[0]+ "#" + cell[1]);
	for (int[] wall : walls)
		blocks.add(wall[0] + "#"+ wall[1]);
	occupied = new HashSet<>();;
	for (int[] gard : gards) {
		int row = gard[0];
		int col = gard[1];
		checkNorthCell(row, col, blocks, m, n);
        checkSouthCell(row, col, blocks, m, n);
        checkEastCell(row, col, blocks, m, n);
        checkWestCell(row, col, blocks, m, n);
    }
    return  (m * n - occupied.size() - gards.length - walls.length);
}


public void checkNorthCell(int row, int col, Set<String>blocks, int m, int n) {
	if (row == 0) return;
	for (int i = row - 1; i >= 0; i--) {
        String cell = i + "#" +col;
		if (blocks.contains(cell))
			break;
		occupied.add(cell);
    }
}


public void checkSouthCell(int row, int col, Set<String>blocks, int m, int n) {
	if (row == m - 1) return;
	for (int i = row + 1; i < m; i++) {
        String cell = i + "#" +col;
		if (blocks.contains(cell))
			break;
		occupied.add(cell);
    }
}


public void checkEastCell(int row, int col, Set<String>blocks, int m, int n) {
	if (col == 0) return;
	for (int i = col - 1; i >= 0; i--) {
        String cell = row + "#" + i;
		if (blocks.contains(cell))
			break;
		occupied.add(cell);
    }
}


public void checkWestCell(int row, int col, Set<String>blocks, int m, int n) {
	int count = 0;
	if (col == n - 1) return;
	for (int i = col + 1; i < n; i++) {
        String cell = row + "#" + i;
		if (blocks.contains(cell))
			break;
		occupied.add(cell);
    }
}

}