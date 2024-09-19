class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        curr.add(0);
        backtrack(curr, 0, graph);
        return (ans);
    }

    public void backtrack(List<Integer> curr, int node, int[][] graph) {
        if (node == graph.length - 1) {
            ans.add(new ArrayList<Integer>(curr));
            return ;
        }
        for (int nei : graph[node]) {
            curr.add(nei);
            backtrack(curr, nei, graph);
            curr.remove(curr.size() - 1);
        }
    }


}
/**
    - DAG n node 0 - n-1
    - all possib;e node 0 to n-1 return them
    - graph[i] all i connection
        -       [0]
        [1]  [2]
        [3]     [3]
        base case n = n - 1
 */