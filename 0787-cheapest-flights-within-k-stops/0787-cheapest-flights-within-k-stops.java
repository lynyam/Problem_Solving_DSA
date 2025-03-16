class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adjList = new ArrayList<>();
        //build adjacent graph
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<int[]>());
        }
        for (int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];
            adjList.get(from).add(new int[]{to, price});
        }
        //create priority queue for djiskastra
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        int[] stops = new int[n];
        Arrays.fill(stops, Integer.MAX_VALUE);
        //stops[src] = 0;
        queue.add(new int[]{src, 0, 0});
        
        //walk through on graph from src to dst
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int node = curr[0];
            int price = curr[1];
            int stop = curr[2];
            if (stop > stops[node] || stop > k + 1) continue;
            stops[node] = stop;
            if (node == dst) return (price);
            for (int[] nei : adjList.get(node)) {
                int neiPrice = price + nei[1];
                int neiNode = nei[0];
                //if (prices[neiNode] > neiPrice && stop + 1 <= k) {
                    
                    queue.add(new int[]{neiNode, neiPrice, stop + 1});
                //}
            }
        }
        return -1;
    }
}