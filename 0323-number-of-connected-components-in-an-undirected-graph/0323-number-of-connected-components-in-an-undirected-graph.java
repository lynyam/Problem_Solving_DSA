class Solution {
    HashMap<Integer, List<Integer>> graph;
    boolean[] seen;

    public void buildGraph(int[][] edges) {
        for (int [] edge : edges) {
            graph.putIfAbsent(edge[0], new ArrayList<Integer>());
            graph.putIfAbsent(edge[1], new ArrayList<Integer>());
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
    }

    public int countComponents(int n, int[][] edges) {
        graph = new HashMap<>();
        seen = new boolean[n];
        int i = 0;
        int ans = 0;

        buildGraph(edges);
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
        for (int neighbor : graph.getOrDefault(node, new ArrayList<Integer>())) {
            if (!seen[neighbor]) {
                seen[neighbor] = true;
                dfs(neighbor);
            }
        }
    }
}