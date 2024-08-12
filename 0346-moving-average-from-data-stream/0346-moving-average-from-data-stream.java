class MovingAverage {
    int size;
    double sum;
    Queue<Integer> queue;

    public MovingAverage(int size) {
        queue = new LinkedList<>();
        this.size = size;
        sum = 0;
    }
    
    public double next(int val) {
        sum += val;
        queue.add(val);
        while (queue.size() > size)
            sum -= queue.remove();
        return (sum / queue.size());
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
 /*
    - stream of integer
    - size window
    - calculate moving average of all int in slide windows
    - MvingAverage(int size) init object with size 
 */