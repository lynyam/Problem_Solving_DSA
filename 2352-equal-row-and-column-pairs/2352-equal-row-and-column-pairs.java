class Solution {
    public int equalPairs(int[][] grid) {
        HashMap<String, Integer> store = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int n = grid.length;
        String r;
        int ans = 0;

        for (int[] row : grid) {
            sb = new StringBuilder();
            for (int ri : row) {
                sb.append(ri);
                sb.append("#");
            }
            r = sb.toString();
            store.put(r, store.getOrDefault(r, 0) + 1);
        }
        int i = 0;
        while (i < n) {
            int j = 0;
            sb = new StringBuilder();
            while (j < n) {
                sb.append(grid[j][i]);
                sb.append("#");
                j++;
            }
            r = sb.toString();
            ans += store.getOrDefault(r, 0);
            i++;
        }
        return (ans);
    }

}
/**
    - grid[][] n x n
    - ret number of pairs (ri, cj)
        - ri == cj
        - == meaning contains same elts in the same order(equal array)
 */