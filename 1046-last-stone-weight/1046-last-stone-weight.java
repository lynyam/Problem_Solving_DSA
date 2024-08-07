class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();

        for (int n : stones) {
            maxHeap.add(-1 * n);
        }
        while (maxHeap.size() > 1) {
            int max1 = maxHeap.remove();
            int max2 = maxHeap.remove();
            if (max1 != max2)
                maxHeap.add(max1 - max2);
        }
        return (!maxHeap.isEmpty() ? -1 * maxHeap.remove() : 0);
    }
}/*
    - stones int[]
        - stones[i] weight of ith stone
    - each turn, choose max two stones[i] ans smash
        - x, y stones turn i x<= y smatch =>
            - x == y delete x && y
            - x != y delete x and y = y - x
    - end game: one stone left, return or 0
    result:nlogn time n space 
        - convert arr on heap max //nlogn time n space
        - while heapMax not empty
            - remove max1 and max2 //nlogn time reduce space => 0(1)
            - if (max1 != max2)
                - add to heap (max2 - max1) //n/2logn
*/