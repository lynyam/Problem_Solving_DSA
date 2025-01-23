class Solution {
    List<List<Integer>> answer;
    int[][] graph;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        answer = new ArrayList<>();
        this.graph = graph;
        List<Integer> curr = new ArrayList<Integer>();
        curr.add(0);
        backtrack(curr, 0);
        return (answer);
    }

    public void backtrack(List<Integer> curr, int node) {
        if (node == graph.length -1 ) {
            answer.add(new ArrayList<Integer>(curr));
            return ;
        }
        for (int neighbor : graph[node]) {
            curr.add(neighbor);
            backtrack(curr, neighbor);
            curr.remove(curr.size() - 1);
        }
    }
}