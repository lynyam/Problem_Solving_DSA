class Solution {
    List<List<Integer>> graph;
    boolean[] seen;
    int ans = 1;

    public void buildGraph(int[][] edges) {
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
    }

    public void initGraph(int n) {
        int i = 0;
    
        while (i < n) {
            graph.add(new ArrayList<Integer>());
            i++;
        }
    }

    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        graph = new ArrayList<>();
        seen = new boolean[n];
        int i = 0;

        initGraph(n);
        buildGraph(edges);
        seen[0] = true;
        while (i < restricted.length) {
            seen[restricted[i]] = true;
            i++;
        }
        dfs(0);
        return (ans);
    }

    public void dfs(int node) {
        for (int neighbor : graph.get(node)) {
            if (!seen[neighbor]) {
                seen[neighbor] = true;
                ans++;
                dfs(neighbor);
            }
        }
    }
}