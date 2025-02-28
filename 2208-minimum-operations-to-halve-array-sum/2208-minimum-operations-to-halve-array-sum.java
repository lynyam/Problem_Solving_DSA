class Solution {
	public int halveArray( int[] nums) {
		double sum = 0;
		PriorityQueue<Double> heap = new PriorityQueue<>(Comparator.reverseOrder());
		for (int num : nums) {
			sum += num;
			heap.add((double)num);
		}
		double value = sum;
		int result = 0;
		while (value > sum / 2.0) {
			double curr = heap.poll() / 2.0;
			value -= curr;
            heap.add(curr);;
			result++;
		}
		return (result);
	}
}
