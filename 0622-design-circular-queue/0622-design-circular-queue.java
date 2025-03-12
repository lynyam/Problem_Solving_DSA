class MyCircularQueue {
    int capacity;
	int start;
	int end;
	int size;
	int[] queue;

    public MyCircularQueue(int c) {
        capacity = c;
		start = 0;
		end = -1;
		size = 0;
		queue = new int[c];
    }
    
    public boolean enQueue(int value) {
        if (isFull())
		    return (false);
        size++;
        end = (end + 1) % capacity;
        queue[end] = value;
        return (true);
    }
    
    public boolean deQueue() {
        if (isEmpty())
		    return (false);
        size--;
        start = (start + 1) % capacity;
        return (true);
    }
    
    public int Front() {
        if (isEmpty())
            return (-1);
        return (queue[start]);
    }
    
    public int Rear() {
        if (isEmpty())
            return (-1);
        return (queue[end]);
    }
    
    public boolean isEmpty() {
        return (size == 0);
    }
    
    public boolean isFull() {
        return (size == capacity);
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */