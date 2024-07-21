class Solution {
    boolean[] seen;
    List<Integer> ans;

    public void builGraph(List<List<Integer>> edges) {
        for (List<Integer> edge : edges) {
            seen[edge.get(1)] = true;
        }
    }
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        seen = new boolean[n];
        ans = new ArrayList<>();
        int i = 0;
        builGraph(edges);
        while (i < n) {
            if (!seen[i]) {
                ans.add(i);
            }
            i++;
        }
        return (ans);
    }
}