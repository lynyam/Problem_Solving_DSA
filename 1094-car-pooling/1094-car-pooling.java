class Solution {
	public boolean carPooling(int[][] trips, int capacity) {
		//search max drop and create area of this size
		int maxDrop = 0;
		int minDrop = 0;
		for (int[] trip : trips) {
			maxDrop = Math.max(maxDrop, trip[2]);
            minDrop = Math.min(minDrop, trip[1]);
		}


		int[] road = new int[maxDrop + 1];
		for (int[] trip : trips) {//0(n), n trip
			road[trip[1]] += trip[0];
			road[trip[2]] -= trip[0];
		}
        int curr = 0;
		for (int i = minDrop; i <= maxDrop; i++) {//maxDrop
			road[i] += curr;
			if (road[i] > capacity)
				return (false);
            curr = road[i];
		}
		return (true);
	}
}
