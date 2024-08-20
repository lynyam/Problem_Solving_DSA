class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int num : nums) {
            heap.add(num);
            if (heap.size() > k) {
                heap.remove();
            }
        }
        return (heap.remove());
    }
}
/**
    - nums int[]
    - int k
    - ret kth largest elt in the array
        - kth lasgest elt in sorted order, not kth disting elt
        - not sort array
 */