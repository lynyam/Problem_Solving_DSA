class Solution {
    boolean[] seen;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        seen = new boolean[n];
        seen[0] = true;
        dfs(0, rooms);
        return (is_all_visited(n));
    }

    public void dfs(int node, List<List<Integer>> rooms) {
        for (int neighbor : rooms.get(node)) {
            if (!seen[neighbor]) {
                seen[neighbor] = true;
                dfs(neighbor, rooms);
            }
        }
    }

    public boolean is_all_visited(int n) {
        int i = 0;
        while (i < n) {
            if (!seen[i])
                return (false);
            i++;
        }
        return (true);
    }
}