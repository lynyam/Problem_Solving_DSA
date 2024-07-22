class Solution {
    boolean[] seen;
    List<List<Integer>> adjList;

    void    buildGraph(int n, int[][] edges) {
        int i = 0;
        while (i < n) {
            adjList.add(new ArrayList<>());
            i++;
        }
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
    }
    public int countComponents(int n, int[][] edges) {
        seen = new boolean[n];
        adjList = new ArrayList<>();
        int ans = 0;
        int i = 0;

        buildGraph(n, edges);
        while (i < n) {
            if (!seen[i]) {
                seen[i] = true;
                ans++;
                dfs(i);
            }
            i++;
        }
        return (ans);
    }

    public void dfs(int node) {
        for (int neighbor : adjList.get(node)) {
            if (!seen[neighbor]) {
                seen[neighbor] = true;
                dfs(neighbor);
            }
        }
    }
}