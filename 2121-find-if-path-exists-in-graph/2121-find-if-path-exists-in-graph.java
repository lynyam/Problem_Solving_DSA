class Solution {
    List<List<Integer>> adjList;
    boolean[] seen;

    public void buildGraph(int[][] edges, int n) {
        int i = 0;

        while (i < n) {
            adjList.add(new ArrayList<Integer>());
            i++;
        }
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            adjList.get(from).add(to);
            adjList.get(to).add(from);
        }
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        adjList = new ArrayList<>();
        seen = new boolean[n];
        
        if (source == destination)
            return (true);
        buildGraph(edges, n);
        if (adjList.get(source).isEmpty() || adjList.get(destination).isEmpty())
            return (false);
        seen[source] = true;
        return (dfs(source, destination));
    }

    public boolean dfs(int s, int d) {
        boolean ans = false;
        if (s == d)
            return (true);
        for (int nei : adjList.get(s)) {
            if (!seen[nei]) {
                seen[nei] = true;
                ans |= dfs(nei, d);
            }
        }
        return (ans);
    }
}
/*
    - bi-direction graph
    - n vertices 0 to n - 1 (inclu..)
    - edges is. 2D int[] edges
        - edges[i] = [ui, vi] => ui-><-vi
        - every vertes is connected / one edge mini / no vertex edge itself
    - det if valid path exist s -> d
    - in: edges, n, d, s, 
    - ret true if  or false
*/