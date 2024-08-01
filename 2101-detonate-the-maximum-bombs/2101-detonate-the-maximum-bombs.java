class Solution {
    HashMap<Integer, List<Integer>> graph;

    public void buildGraph(int[][] bombs) {
        int n = bombs.length;
        int i = 0;
        while (i < n) {
            graph.put(i, new ArrayList<>());
            int j = 0;
            while (j < n) {
                if (i == j) {
                    j++;
                    continue ;
                }
                long x = bombs[i][0] - bombs[j][0];
                long y = bombs[i][1] - bombs[j][1];
                if ((long)bombs[i][2] * bombs[i][2] >= x*x + y*y) {
                    graph.get(i).add(j);
                }
                j++;
            }
            i++;
        }

        
    }

    public int maximumDetonation(int[][] bombs) {
        int ans = 0;
        graph = new HashMap<>();
        int n = bombs.length;
        int i = 0;
        buildGraph(bombs);
        while (i < n) {
            int count = dfs(i, new HashSet<>());
            ans = Math.max(ans, count);
            i++;
        }
        return (ans);
    }

    public int dfs(int node, Set<Integer> seen) {
        int connection = 1;
        seen.add(node);
        for (int neighbor : graph.get(node)) {
            if (!seen.contains(neighbor)) {
                connection += dfs(neighbor, seen);
            }
        }
        return (connection);
    }
}
/*
    - list<Bomb> bombs => 
        - bomb range = area effet can be felt
            - area = cricle center bomb location
        - bombs[i] = [xi, yi, ri], (xi, yi) coordinate, ri radius
    - detonate a single bomb bombs[i]
        - bombs[i] detonate all bombs area =2pir2 .. .. 
    - ret. max bombs detonate if you allowed to detonate one

    node = bombs[i]
    adge = r
*/
