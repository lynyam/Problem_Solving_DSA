class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int i = 0;

        while (i < nums.length) {
            heap.add(nums[i]);
            if (heap.size() > k) {
                heap.remove();
            }
            i++;
        }
        return (heap.peek());
    }
}
/**
    - nums int[]
    - k int
    - ret kth largest elt in array
    - kth largest elt in sorted array, not kth distinct elt
    - solve withoup solving
 */