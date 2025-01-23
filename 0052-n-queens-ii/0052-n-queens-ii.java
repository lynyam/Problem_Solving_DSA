class Solution {
    int n;
    int ans;
    public int totalNQueens(int n) {
        this.n = n;
        ans = 0;
        backtrack(0, 0, 0, 0);
        return (ans);
    }

    public void backtrack(int x, int cols, int diag, int antiDiag) {
        if (x == n) {
            ans++;
            return ;
        }
        int j = 0;
        while (j < n) {
            if ((cols & (1 << j)) == 0 && (diag & (1 << (x - j + n))) == 0 && (antiDiag & (1 << (x + j))) == 0) {
                backtrack(x + 1, cols | (1 << j), diag | (1 << (x - j + n)), antiDiag | (1 << (x + j)));
            }
            j++;
        }
    }
}