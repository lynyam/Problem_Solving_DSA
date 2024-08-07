class Solution {
    List<Integer>[] adjList;
    boolean[] seen;
    int ans;
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        adjList = new ArrayList[n];
        seen = new boolean[n];
        int i = 0;
        ans = 1;

        while (i < n) {
            if (i < restricted.length)
                seen[restricted[i]] = true;
            if (i == 0)
                seen[i] = true;
            adjList[i] = new ArrayList<Integer>();
            i++;
        }
        buildGraph(edges);
        dfs(0);
        return (ans);
    }

    public void dfs(int node) {
        for (int neighbor : adjList[node]) {
            if (!seen[neighbor]) {
                seen[neighbor] = true;
                ans++;
                dfs(neighbor);
            }
        }
    }

    public void buildGraph(int[][] edges) {
        for (int[] edge : edges) {
            adjList[edge[0]].add(edge[1]);
            adjList[edge[1]].add(edge[0]);
        }
    }
}
/*
    - undirect tree n node 
    - 0 to n -1
    - n-1 edge
    - edges int[][] len = n-1
        - edges[i] = [ai, bi], ai->bi
    - restr int[] restrict node
    - ret : max number of nodes you can reach from node 0 without visit a restricted node
    - node 0 not restrict

    result:
    - buildGraph adjLst List<Integer>[n]
    - mark node 0 visited
    - mark restricted node visited
    - make dfs on 0 node
        - while neighbor exits for node 0
            - if not visited
                - mark as visited
                - count++
                - dfs(neighbor)
    - return count// declare count global and initialise to 0

*/