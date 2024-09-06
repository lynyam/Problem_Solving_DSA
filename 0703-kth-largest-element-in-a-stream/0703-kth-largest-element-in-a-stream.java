class KthLargest {
    PriorityQueue<Integer> heap;
    int k;

    public KthLargest(int k, int[] nums) {
        heap = new PriorityQueue<>();
        this.k = k;
        for (int num : nums) {
            add(num);
        }
    }
    
    public int add(int val) {
        heap.add(val);
        if (heap.size() > k)
            heap.remove();
        return (heap.peek());
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
 /**
    - kth highest test score
    - int k ret kth highest test score after new score has been sub
    - kth highest in sorted list
  */