class Solution {
    HashMap<Integer, List<Integer>> graph;
    boolean[] seen;
    HashSet<String> currentRoads;
    int ans = 0;

    public String convertToHash(int n1, int n2) {
        return (String.valueOf(n1) + "," + String.valueOf(n2));
    }

    public void buildGraph(int[][] connections) {
        for (int[] connection : connections) {
            graph.putIfAbsent(connection[0], new ArrayList<Integer>());
            graph.putIfAbsent(connection[1], new ArrayList<Integer>());
            graph.get(connection[0]).add(connection[1]);
            graph.get(connection[1]).add(connection[0]);
            currentRoads.add(convertToHash(connection[0], connection[1]));
        }
    }
    public int minReorder(int n, int[][] connections) {
        graph = new HashMap<>();
        seen = new boolean[n];
        currentRoads = new HashSet<>();

        buildGraph(connections);
        seen[0] = true;
        dfs(0);
        return (ans);
    }

    public void dfs(int city) {
        for (int neighbor : graph.get(city)) {
            if (!seen[neighbor]) {
                if (currentRoads.contains(convertToHash(city, neighbor)))
                    ans++;
                seen[neighbor] = true;
                dfs(neighbor);
            }
        }
    }
}