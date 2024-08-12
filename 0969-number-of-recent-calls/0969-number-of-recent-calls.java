class RecentCounter {
    Queue<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }
    
    public int ping(int t) {
        queue.add(t);
        while (!queue.isEmpty() && queue.peek() < t - 3000) {
            queue.poll();
        }
        return (queue.size());
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
 /*
    - class
        - count number of recent requests within time framet
        - recentConter() .. initialise counter with zero request
        - ping(int t) add queste at time t, ms,
            - ret: number of request that has happenned in [t t-3000] 
            - each ping call t>told
            0 0.5 1 2 3 4  11 dernier
            0=>0
            0.5=>1 [0,5, 2]
            1 => [1, 3]
            2=> [2, 4]
            3=>[3, 5]
            4=>[4, 6]
            11
 */