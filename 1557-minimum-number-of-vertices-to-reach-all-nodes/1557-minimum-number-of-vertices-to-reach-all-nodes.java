class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        boolean[] store = new boolean[n];
        List<Integer> ans = new ArrayList<>();
        int i = 0;
        
        for (List<Integer> edge : edges) {
            store[edge.get(1)] = true;
        }
        while (i < n) {
            if (!store[i])
                ans.add(i);
            i++;
        }
        return (ans);
    }
}