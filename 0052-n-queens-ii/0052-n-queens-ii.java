class Solution {
    int ans;
    HashSet<Integer> vertical;
    HashSet<Integer> diag;
    HashSet<Integer> antidiag;
    public int totalNQueens(int n) {
        ans = 0;
        vertical = new HashSet<>();
        diag = new HashSet<>();
        antidiag = new HashSet<>();
        backtrack(0, n);
        return (ans);
    }

    public void backtrack(int row, int n) {
        if (row == n) {
            ans++;
            return ;
        }
        int col = 0;
        while (col < n) {
            if (!vertical.contains(col) && !diag.contains(col - row) && 
                !antidiag.contains(col + row)) {
                vertical.add(col);
                diag.add(col - row);
                antidiag.add(col + row);
                backtrack(row + 1, n);
                vertical.remove(col);
                diag.remove(col - row);
                antidiag.remove(col + row);
            }
            col++;
        }
    }
}