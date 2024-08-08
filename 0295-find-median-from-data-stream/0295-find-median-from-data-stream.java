class MedianFinder {
    PriorityQueue<Integer> heapRight;
    PriorityQueue<Integer> heapLeft;


    public MedianFinder() {
        heapRight = new PriorityQueue<>();
        heapLeft = new PriorityQueue<>(Comparator.reverseOrder());
    }
    
    public void addNum(int num) {
        heapLeft.add(num);
        heapRight.add(heapLeft.remove());
        if (heapRight.size() > heapLeft.size())
            heapLeft.add(heapRight.remove());
    }
    
    public double findMedian() {
        if (heapLeft.size() > heapRight.size()) {
            return ((double)heapLeft.peek());
        }
        return ((heapLeft.peek() + heapRight.peek()) / 2.0);
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
 /*
    - median = midle val in List<Int> ordered
    - if List.size() % 2 == 0
        - No middle value
        - median = 2 middle val median
            - ex: arr = [2, 3, 4] med = 3
            - ex: arr = [2, 3] med = 2+3 /2 = 2.5
    - impl median class MedianFinder
        - init MedianFinder Objet
        - void addNum(int num) adds num (int) from dataStream->data struct
        - double findMedian() return the median of all elt so far
 */