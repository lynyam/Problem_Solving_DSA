class Solution {
    List<List<Integer>> adjList;
    int n;
    int max = 0;
    public int maximumDetonation(int[][] bombs) {
        n = bombs.length;
        int i = 0;
        adjList = new ArrayList<>();

        buildGraph(bombs);
        while (i < n) {
            max = Math.max(max, dfs(i, new boolean[n]));
            i++;
        }
        return (max);
    }

    public int dfs(int node, boolean[] seen) {
        int ans = 1;
        seen[node] = true;
        for (int neighbor : adjList.get(node)) {
            if (!seen[neighbor]) {
                ans += dfs(neighbor, seen);
            }
        }
        return (ans);
    }

    public void buildGraph(int[][] bombs) {
        int i = 0;
        while (i < n) {
            int j = 0;
            int xi = bombs[i][0];
            int yi = bombs[i][1];
            int ri = bombs[i][2];
            adjList.add(new ArrayList<Integer>());
            while (j < n) {
                int xj = bombs[j][0];
                int yj = bombs[j][1];
                int rj = bombs[j][2];
                if ((double)(xi - xj) * (xi - xj) + (double)(yi - yj) * (yi - yj) <=
                    (double)ri * ri) {
                    adjList.get(i).add(j);
                }
                j++;
            }
            i++;
        }
    }
}
/*
    - bombs List<>
        - bonbs[i] = [xi, yi, ri]
    - range bpmbs[i] is area where effet can be felt
        - area = shape circle
            - center = loacation of bob
            - ri = radius
    - Detonate sigle bomb => detonate all bombs in dist() <= ri
    - ret max number of bomb can detonate if you detyonate one
*/