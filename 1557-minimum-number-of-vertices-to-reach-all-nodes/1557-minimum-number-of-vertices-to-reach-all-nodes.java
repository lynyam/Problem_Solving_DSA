class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        boolean[] seen = new boolean[n];
        List<Integer> ans = new ArrayList<>();
        int i = 0;

        for (List<Integer> edge : edges) {
            seen[edge.get(1)] = true;
        }
        while (i < n) {
            if (seen[i] == false) {
                ans.add(i);
            }
            i++;
        }
        return (ans);
    }
}