class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>(Comparator.reverseOrder());
        maxHeap = new PriorityQueue<>(); 
    }
    
    public void addNum(int num) {
        minHeap.add(num);
        maxHeap.add(minHeap.remove());
        if (maxHeap.size() > minHeap.size()) {
            minHeap.add(maxHeap.remove());
        }
    }
    
    public double findMedian() {
        return (maxHeap.size() == minHeap.size() ? (minHeap.peek() + maxHeap.peek()) / 2.0 : minHeap.peek());
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
 /**
    - median = middle val in ordered integer list
    - size % 2 == 2
        - median = midle1 + midle2 / 2
    - void addNum(int num)
        - add num to dsa
    - double findMedian()
        - return median of all elt
  */