class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        ans = new ArrayList<>();
        backtrack(new ArrayList<Integer>(Arrays.asList(0)), 0, graph);
        return (ans);
    }

    public void backtrack(List<Integer> curr, int node, int[][] graph) {
        if (node == graph.length - 1) {
            ans.add(new ArrayList<>(curr));
            return ;
        }
        for (int neig : graph[node]) {
            curr.add(neig);
            backtrack(curr, neig, graph);
            curr.remove(curr.size() - 1);
        }
    }
}