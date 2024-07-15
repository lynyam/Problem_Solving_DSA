class Solution {
    int ans = 0;
    HashSet<String> roads;
    public void buildGraph(HashMap<Integer, List<Integer>> graph, int[][] connections, HashSet<String> roads) {
        for (int[] connection : connections) {
            graph.putIfAbsent(connection[0], new ArrayList<Integer>());
            graph.putIfAbsent(connection[1], new ArrayList<Integer>());
            graph.get(connection[0]).add(connection[1]);
            graph.get(connection[1]).add(connection[0]);
            roads.add(String.valueOf(connection[0]) + "," + String.valueOf(connection[1]));
        }
    }
    public int minReorder(int n, int[][] connections) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        roads = new HashSet<>();
        boolean[] seen = new boolean[n];
        buildGraph(graph, connections, roads);
        int i = 0;
        seen[0] = true;
        dfs(0, graph, seen);
        /*while (i < n) {
            if (!seen[i]) {
                seen[i] = true;
                dfs(i, graph, seen);
            }
            i++;
        }*/
        return (ans);
    }

    public void dfs(int node, HashMap<Integer, List<Integer>> graph, boolean[] seen) {
        for (Integer neighbor : graph.getOrDefault(node, new ArrayList<Integer>())) {
            if(!seen[neighbor]) {
                if (roads.contains(String.valueOf(node) + "," + String.valueOf(neighbor)))
                    ans++;
                seen[neighbor] = true;
                dfs(neighbor, graph, seen);
            }
 
        }
    }
}