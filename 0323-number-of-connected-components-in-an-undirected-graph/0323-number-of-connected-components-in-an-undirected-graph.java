class Solution {
    List<List<Integer>> graph;
    boolean[] seen;

    public void builGraph(int n, int[][] edges) {
        int i = 0;
        while (i < n) {
            graph.add(new ArrayList<Integer>());
            i++;
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
    }
    public int countComponents(int n, int[][] edges) {
        graph = new ArrayList<>();
        seen = new boolean[n];
        int ans = 0;
        int i = 0;

        builGraph(n, edges);
        i = 0;
        while (i < n) {
            if (!seen[i]) {
                ans++;
                seen[i] = true;
                dfs(i);
            }
            i++;
        }
        return (ans);
    }

    public void dfs(int node) {
        for (int neighbor : graph.get(node)) {
            if (!seen[neighbor]) {
                seen[neighbor] = true;
                dfs(neighbor);
            }
        }
    }
}