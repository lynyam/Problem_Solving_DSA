class Solution {
    List<List<Integer>> adjList;
    boolean[] seen;

    public void buildGraph(int[][] edges) {
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        seen = new boolean[n];
        adjList = new ArrayList<>();
        int i = 0;
        while (i < n) {
            adjList.add(new ArrayList<Integer>());
            i++;
        }
        buildGraph(edges);
        seen[source] = true;
        return (dfs(source, destination));
    }

    public boolean dfs(int source, int destination) {
        boolean ans = false;
        if (source == destination) {
            return (true);
        }
        for (int neighbor : adjList.get(source)) {
            if (!seen[neighbor]) {
                seen[neighbor] = true;
                ans |= dfs(neighbor, destination);
            }
        }
        return (ans);
    }
}