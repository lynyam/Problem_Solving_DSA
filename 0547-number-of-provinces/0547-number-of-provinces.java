class Solution {
    public int findCircleNum(int[][] isConnected) {
        if (isConnected == null || isConnected.length == 0) return (0);
        int n = isConnected.length;
        boolean[] seen = new boolean[n];
        int result = 0;

        for (int node = 0; node < n; node++) {
            if (!seen[node]) {
                result++;
                seen[node] = true;
                dfs(node, seen, isConnected);
            }
        }
        return (result);
    }

    public void dfs(int node, boolean[] seen, int[][] isConnected) {
        for (int nei = 0; nei < isConnected[0].length; nei++) {
            if (!seen[nei] && isConnected[node][nei] == 1) {
                seen[nei] = true;
                dfs(nei, seen, isConnected);
            }
        }
    } 
}