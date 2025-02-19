class Node {
	int vertex;
	int price;
	int stop;
	public Node (int v, int p, int s) {
		vertex = v;
		price = p;
		stop = s;
	}
}

class Solution {
	public List<List<Node>> buildGraph(int[][] prices, int n) {
		List<List<Node>> graph = new ArrayList<>();
        int i = 0;
        while (i <= n) {
            graph.add(new ArrayList<>());
            i++;
        }
        for (int[] price : prices) {
            graph.get(price[0]).add(new Node(price[1], price[2], 0));
        }
        return (graph);	
	}

	public int findCheapestPrice(int n, int[][] prices, int src, int dst, int k) {
        List<List<Node>> graph = buildGraph(prices, n);
        int[][] distance = new int[n+1][k + 1];
        for (int[] dist : distance) {
            Arrays.fill(dist, Integer.MAX_VALUE);
        }
        //Arrays.fill(distance[src], 0);
        distance[src][0] = 0;
        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt((Node p) -> p.price).thenComparingInt(p -> p.stop));
        int i = 0;
        minHeap.add(new Node(src, 0, -1));
        while (!minHeap.isEmpty()) {
            Node curr = minHeap.poll();
            for (Node nei : graph.get(curr.vertex)) {
                int vertex = nei.vertex;
                int price = nei.price + curr.price;
                int stop = curr.stop + 1; 
                if (stop <= k && price  < distance[vertex][stop]) {
                    distance[vertex][stop] = price;
                    minHeap.add(new Node(vertex, price, stop));
                }
            }
	    }
        i = 0;
        int max = Integer.MAX_VALUE;
        while (i <= k) {
            //System.out.println(distance[dst][i]);
            max = Math.min(max, distance[dst][i]);
            i++;
        }
        return (max == Integer.MAX_VALUE ? -1 : max);
	}
}
