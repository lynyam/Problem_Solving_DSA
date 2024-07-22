class Solution {
    List<List<Integer>> adjList;
    boolean[] seen;
    int ans = 0;

    public void buildGraph(int n, int[][] edges)  {
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

    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        seen = new boolean[n];
        adjList = new ArrayList<>();
        int i = 0;

        buildGraph(n, edges);
        while (i < restricted.length) {
            seen[restricted[i]] = true;
            i++;
        }
        seen[0] = true;
        dfs(0);
        return (ans + 1);
    }

    public  void    dfs(int source) {
        for (int neighbor : adjList.get(source)) {
            if (!seen[neighbor]) {
                ans++;
                seen[neighbor] = true;
                dfs(neighbor);
            }
        }
    }

}