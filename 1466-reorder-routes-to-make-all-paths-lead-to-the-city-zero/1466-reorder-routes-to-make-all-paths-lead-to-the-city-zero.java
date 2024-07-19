class Solution {
    List<List<Integer>> adjList;
    HashSet<String> roads;
    boolean[] seen;
    int ans = 0;

    public void builGraph(int n, int[][] connections) {
        int i = 0;

        while (i < n) {
            adjList.add(new ArrayList<Integer>());
            i++;
        }
        for (int[] connection : connections) {
            adjList.get(connection[0]).add(connection[1]);
            adjList.get(connection[1]).add(connection[0]);
            roads.add(convertToHash(connection[0], connection[1]));
        }
    }

    public String convertToHash(int from, int to) {
        return (String.valueOf(from) + "," + String.valueOf(to));
    }
    public int minReorder(int n, int[][] connections) {
        seen = new boolean[n];
        adjList = new ArrayList<>();
        roads = new HashSet<>();

        builGraph(n, connections);
        seen[0] = true;
        dfs(0);
        return (ans);
    }

    public void dfs(int node) {
        for (int neighbor : adjList.get(node)) {
            if (!seen[neighbor]) {
                seen[neighbor] = true;
                if (roads.contains(convertToHash(node, neighbor)))
                    ans++;
                dfs(neighbor);
            }
        }
    } 
}