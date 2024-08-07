class Solution {
    List<List<Integer>> adjList;
    boolean[] seen;

    public void buildGraph(int[][] edges) {
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
    }

    public int countComponents(int n, int[][] edges) {
        seen = new boolean[n];
        adjList = new ArrayList<>();
        int i = 0;
        int count = 0;

        while (i < n)  {
            adjList.add(new ArrayList<Integer>());
            i++;
        }
        buildGraph(edges);
        i = 0;
        while (i < n) {
            if (!seen[i]) {
                seen[i] = true;
                count++;
                dfs(i);
            }
            i++;
        }
        return (count);
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
/*
    - graph n nodes
    - int n
    - edges [][]
            - edges[i] = [ai, bi], edge btw ai->bi
    - ret number of connected component
    result :
        - builGrap ->adjList List<Integer>//0(m) m edge space 0(n + m) t
        - walk throught on node 0 to n-1 //0(n)t
            - if node not visited mark visted and count++
            - call dfs on this node to visited all connected node.
                - while neighbor in List of neighbor of node
                    - if neighbor is not visited 
                        - mark visited and call dfs recursive

        return (count)
*/