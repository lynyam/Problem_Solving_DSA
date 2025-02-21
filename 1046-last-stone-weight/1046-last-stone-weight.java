
class Solution {
	public int	lastStoneWeight(int[] nums) { //2,7,4,1,8,1//1 1 2 //1 1
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());//


	for (int num : nums) {
		maxHeap.add(num);
	}


	while (maxHeap.size() > 1) {
		int difference = maxHeap.poll() - maxHeap.poll();//8 -7=1, 4-2=2
		if (difference > 0)
			maxHeap.add(difference);
	}
	return (!maxHeap.isEmpty() ? maxHeap.poll() : 0);
}
}
