class Solution {
    HashMap<Integer, List<Integer>> graph;
    boolean[] seen;
    int destination;
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination)
            return (true);
        seen = new boolean[n];
        graph = new HashMap<>();
        this.destination = destination;

        buildGraph(edges);
        seen[source] = true;
        return(dfs(source)); 
    }

    public void buildGraph(int[][] edges) {
        for (int[] edge : edges) {
                graph.putIfAbsent(edge[0], new ArrayList<Integer>());
                graph.putIfAbsent(edge[1], new ArrayList<Integer>());
                graph.get(edge[0]).add(edge[1]);
                graph.get(edge[1]).add(edge[0]);
        }
    }

    public boolean dfs(int source) {
        boolean ans = false;
        for (int neighbor : graph.get(source)) {
            if (!seen[neighbor]) {
                seen[neighbor] = true;
                ans |= (neighbor == destination ? true : dfs(neighbor));
            }
        }
        return (ans);
    }
}