class Solution {
    List<List<Integer>> adjList;
    boolean[] seen;
    int ans = 0;
    HashSet<String> roads;

    public void buildGraph(int[][] connections) {
        for (int[] connection : connections) {
            adjList.get(connection[0]).add(connection[1]);
            adjList.get(connection[1]).add(connection[0]);
            roads.add(convertToHash(connection[0], connection[1]));
        }
    }

    public String convertToHash(int from, int to) {
        return (String.valueOf(from) + "_" + String.valueOf(to));
    }

    public int minReorder(int n, int[][] connections) {
        adjList = new ArrayList<>();
        int i = 0;
        seen = new boolean[n];
        seen[0] = true;
        roads = new HashSet<>();
        
        while (i < n) {
            adjList.add(new ArrayList<>());
            i++;
        }
        i = 0;
        buildGraph(connections);
        dfs(0);
        return (ans);
    }

    public void dfs(int capital) {
        for (int city : adjList.get(capital)) {
            if (!seen[city]) {
                seen[city] = true;
                ans += roads.contains(convertToHash(capital,
                    city)) ? 1 : 0;
                    dfs(city);
            }
        }
    }
}