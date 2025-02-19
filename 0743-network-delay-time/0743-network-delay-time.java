class Node {
	int node;
	int time;
	public Node (int n, int t) {
		node = n;
		time = t;
	}
}

class Solution {
	List<List<Node>> buildGraph(int[][] times, int n) {
		List<List<Node>> graph = new ArrayList<>();
		int i = 0;
		while (i <= n) {
			graph.add(new ArrayList<Node>());
			i++;
		}
		for (int[]  time : times) {
			graph.get(time[0]).add(new Node(time[1], time[2]));
        }
        return graph;
    }
	int networkDelayTime(int[][] times, int n, int k) {
		int[] timeStamps = new int[n+1];
		Arrays.fill(timeStamps, Integer.MAX_VALUE);
		timeStamps[k] = 0;
		List<List<Node>> graph = buildGraph(times, n);
		PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(p -> p.time));
        minHeap.add(new Node(k, 0));
        while (!minHeap.isEmpty()){
	        Node node = minHeap.poll();
            int index = node.node;
            int time = node.time;
            for (Node nei : graph.get(index)) {
                int timeStamp = time + nei.time;
                if (timeStamp < timeStamps[nei.node]) {
                    timeStamps[nei.node] = timeStamp;
                    minHeap.add(nei);
                }
            }
		}
		int max = Integer.MIN_VALUE;
        int i  = 1;
		while (i < timeStamps.length) {
            //System.out.println(timeStamps[i]);
			max = Math.max(max, timeStamps[i]);
            i++;
		}
        
		return (max == Integer.MAX_VALUE ? -1 : max);
	}
}
