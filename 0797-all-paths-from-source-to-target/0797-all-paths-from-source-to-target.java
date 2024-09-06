class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<Integer>();
        curr.add(0);
        backtrack(0, curr, graph);
        return (ans);
    }

    public void backtrack(int node, List<Integer> curr, int[][] graph) {
        if (node == graph.length - 1) {
            ans.add(new ArrayList<Integer>(curr));
            return ;
        }
        for (int neighbor : graph[node]) {
            curr.add(neighbor);
            backtrack(neighbor, curr, graph);
            curr.remove(curr.size() - 1);
        }
    }
}
/**
    - DAG n nodes 0 - n-1
    - all possible path from node 0 to n-1 ret in any order
 */