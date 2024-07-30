class Solution {
    boolean[] seen;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        seen = new boolean[n];
        seen[0] = true;
        dfs(0, rooms);
        int i = 0;

        while (i < n) {
            if (!seen[i])
                return (false);
            i++;
        }
        return (true);
    }

    public void dfs(int openRoom, List<List<Integer>> rooms) {
        for (int room : rooms.get(openRoom)) {
            if (!seen[room]) {
                seen[room] = true;
                dfs(room, rooms);
            }
        }
    }
}