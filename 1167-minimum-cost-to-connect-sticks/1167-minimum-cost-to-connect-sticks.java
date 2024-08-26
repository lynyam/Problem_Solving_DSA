class Solution {
    public int connectSticks(int[] sticks) {
        int cost = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int stick : sticks) {
            heap.add(stick);
        }
        while (heap.size() > 1) {
            int stick1 = heap.remove();
            int stick2 = heap.remove();
            cost += (stick1 + stick2);
            heap.add(stick1 + stick2);
        }
        return (cost);
        
    }
}
/**
    - sticks int[]
        - sticks[i] > 0 length of ith stick
    - connect x to y coast x + y.
    - connect all sticks until there is only one stick remaining
    - ret mini coast of connecting all given sticks into one stick this way

 */