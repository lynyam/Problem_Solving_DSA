class Solution {
	public int maximumProduct(int[] nums, int k) {//0(n+k)logn 0(n) space
		if (k <= 0 || nums.length == 0) return (0);
		PriorityQueue<Integer> heap = new PriorityQueue<>();
		for (int num : nums) {//0(nlogn) time 0(n) space
			heap.add(num);
		}
        long result = 1;
        for (int i = 0; i < k; i++) {//0(klogn)
            int min = heap.remove() + 1;
            heap.add(min);
        }
        int MOD = 1000000007;
        while (!heap.isEmpty()) {// 0(nlogn)
            result = (result * heap.remove()) % MOD;
        }
        return (int)(result);
    }
}
