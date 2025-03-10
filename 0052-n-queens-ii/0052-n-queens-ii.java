class Solution {
	int n;
	int result;
	public int totalNQueens(int n) {
		if (n <= 0) return (0);
		if (n == 1) return (1);
		result = 0;
		this.n = n;
		Set<Integer> vertical = new HashSet<>();
		Set<Integer> diag = new HashSet<>();
		Set<Integer> antiDiag = new HashSet<>();
		backtrack(0, vertical, diag, antiDiag);
        return (result);
    }


    public void backtrack(int level, Set<Integer> vertical, Set<Integer> diag, Set<Integer> antiDiag) {
        if (level == n) {
            result++;
            return;
        }
        for (int i = 0; i < n; i++) {
            int diff = i - level;
            int sum = i + level;
            if (!vertical.contains(i) && !diag.contains(diff) && 
            !antiDiag.contains(sum)){
                vertical.add(i);
                diag.add(diff);
                antiDiag.add(sum);
                backtrack(level + 1, vertical, diag, antiDiag);
                vertical.remove(i);
                diag.remove(diff);
                antiDiag.remove(sum);
            }
        }
    }
}
