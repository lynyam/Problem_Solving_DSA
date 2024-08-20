class KthLargest {
    PriorityQueue<Integer> heap;
    int k;


    public KthLargest(int k, int[] nums) {
        heap = new PriorityQueue<>();
        this.k = k;
        for (int num : nums) {
            heap.add(num);
            if (heap.size() > k) {
                heap.remove();
            }
        }
        
    }
    
    public int add(int val) {
        heap.add(val);
        if (heap.size() > k) {
            heap.remove();
        }
        return (heap.peek());
    }
}
/**
    - design class to find kth largest elt in a stream
        - kth largest elt in sorted order not distinct elt
    - class init object with int k ans stream nums
    - add(int val) appends int val to stream and returne the elt represent kth largest il stream

 */
/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */