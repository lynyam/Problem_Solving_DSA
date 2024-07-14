class Solution {
    public void buildGraph(HashMap<Integer, List<Integer>> graph, int[][] isConnected) {
        int i = 0;
        int j = 0;
        int n = isConnected.length;
        while (i < n) {
            j = i + 1;
            graph.putIfAbsent(i, new ArrayList<Integer>());
            while (j < n) {
                graph.putIfAbsent(j, new ArrayList<Integer>());
                if (isConnected[i][j] == 1) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
                j++;
            }
            i++;
        }
    }

    public int findCircleNum(int[][] isConnected) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        int n = isConnected.length;
        int i = 0;
        int ans = 0;
        boolean[] seen = new boolean[n];
        buildGraph(graph, isConnected);

        while (i < n) {
            if (!seen[i]) {
                ans++;
                bfs(i, graph, seen);
            }
            i++;
        }
        return (ans);
    }

    public void bfs(int node, HashMap<Integer, List<Integer>> graph, boolean[] seen) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            int i = 0;
            int size = queue.size();
            while (i < size){
                int currentNode = queue.remove();
                if (!seen[currentNode]) {
                    seen[currentNode] = true;
                    for (Integer connect : graph.get(currentNode)) {
                        queue.add(connect);
                    }
                }              
                i++;
            }  
        }
    }
}