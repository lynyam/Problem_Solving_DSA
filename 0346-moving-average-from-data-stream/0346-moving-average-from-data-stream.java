class MovingAverage {
    int size;
    Queue<Integer> queue;
    double sum;
    public MovingAverage(int size) {
        this.size = size;
        this.sum = 0;
        this.queue = new LinkedList<>();
    }
    
    public double next(int val) {
        queue.offer(val);
        sum += val;
        while (!queue.isEmpty() && queue.size() > size) {
            sum -= queue.poll();
        }
        return (sum / queue.size());
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */