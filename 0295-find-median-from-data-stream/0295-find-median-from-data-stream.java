class MedianFinder{
	PriorityQueue<Integer> leftHeap;
	PriorityQueue<Integer> rightHeap;
	public MedianFinder() {
		leftHeap = new PriorityQueue<>(Comparator.reverseOrder());
		rightHeap = new PriorityQueue<>();
    }


    public void addNum(int num) {
        leftHeap.add(num);
        rightHeap.add(leftHeap.poll());
        while (rightHeap.size() > leftHeap.size() + 1) {
            leftHeap.add(rightHeap.poll());
        }
    }


    public double findMedian() {
        if (rightHeap.size() > leftHeap.size())
            return(rightHeap.peek());
        return ((double) (leftHeap.peek() + rightHeap.peek()) / 2.0);
    }
}


/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */