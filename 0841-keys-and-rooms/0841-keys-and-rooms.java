class Solution {
    HashSet<Integer> seen;
    int n;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        n = rooms.size();
        seen = new HashSet<Integer>();
        seen.add(0);
        dfs(0, rooms);
        return (seen.size() == n);
    }

    public void dfs(int room, List<List<Integer>> rooms) {
        for (int neighbor : rooms.get(room)) {
            if (!seen.contains(neighbor)) {
                seen.add(neighbor);
                dfs(neighbor, rooms);
            }
        }
    }
}