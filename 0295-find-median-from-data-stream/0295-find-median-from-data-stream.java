class MedianFinder {
    PriorityQueue<Integer> leftHeap;
    PriorityQueue<Integer> rightHeap;

    public MedianFinder() {
        leftHeap = new PriorityQueue<>(Comparator.reverseOrder());
        rightHeap = new PriorityQueue<>();
        
    }
    
    public void addNum(int num) {
        leftHeap.add(num);
        rightHeap.add(leftHeap.remove());
        if (rightHeap.size() > leftHeap.size()) {
            leftHeap.add(rightHeap.remove());
        }
    }
    
    public double findMedian() {
        return (leftHeap.size() > rightHeap.size() ? leftHeap.peek() : 
            ((double)leftHeap.peek() + rightHeap.peek())/ 2.0);
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();

    - median = midle val in ordered int list
 */