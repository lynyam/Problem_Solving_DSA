class Solution {
    boolean[] seen;
    HashMap<Integer, List<Integer>> graph;
    int destination;

    public void buildGraph(int[][] edges) {
        for (int[] edge: edges) {
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.putIfAbsent(edge[1], new ArrayList<>());
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination)
            return (true);
        this.destination = destination;
        seen = new boolean[n];
        graph = new HashMap<>();

        buildGraph(edges);
        seen[source] = true;
        return (dfs(source));
    }

    public boolean dfs(int source) {
        boolean ans = false;
        for (int neighbor : graph.getOrDefault(source, new ArrayList<Integer>())) {
            if (!seen[neighbor]) {
                seen[neighbor] = true;
                ans |= (neighbor == destination || dfs(neighbor));
            }
        }
        return (ans);
    }
}