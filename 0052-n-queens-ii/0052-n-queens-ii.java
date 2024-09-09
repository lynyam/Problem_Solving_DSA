class Solution {
    int size;
    int ans;
    public int totalNQueens(int n) {
        ans = 0;
        size = n;
        backtrack(0, new HashSet<Integer>(), new HashSet<Integer>(), new HashSet<Integer>());
        return (ans);
    }

    public void backtrack(int row, HashSet<Integer> seenCol, HashSet<Integer> seenDiag, HashSet<Integer> seenAntDiag) {
        if (row == size) {
            ans++;
            return ;
        }
        int col = 0;
        while (col < size) {
            if (seenCol.contains(col) || seenDiag.contains(row - col) || seenAntDiag.contains(row + col)) {
                col++;
                continue ;
            }
            seenCol.add(col);
            seenDiag.add(row - col);
            seenAntDiag.add(row + col);
            backtrack(row + 1, seenCol, seenDiag, seenAntDiag);
            seenCol.remove(col);
            seenDiag.remove(row - col);
            seenAntDiag.remove(row + col);
            col++;
        }
    }
}
/**
    - - placing n queens on nxn chessboard
        - no two queens attack each other
    - n int, ret number of distinct solution to the n-puzzle

        0,  1   -1 x    y x-y =z x+y=t
        1,  0    1 x+1, y-1 x+y =t
        1,  2    -1 x+1, y+1 x-y = z
        2,  3    -1
 */