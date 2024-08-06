class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int num : stones) {
            heap.add(-1 * num);
        }
        while (!heap.isEmpty()) {
            int heav1 = heap.remove();
            if (!heap.isEmpty()) {
                int heav2 = heap.remove();
                if (heav2 != heav1) {
                    heap.add(heav1 - heav2);
                }
            }
            else
                return (-1 * heav1);
        }
        return (0);
        
    }
}
/*
    - stones int[]
        - stones[i] weight of ith stone
    - each turn/ chooz heaviest 2 stones and smash them togeteher
        ex: s1 x, s2 y x <=y sm = 
        - x = y destroy s1 and 2
        - s != y destr s1 x and s2 y = y - x
    - end game one stone
    - ret: wei of last remanig stone | if no 0
*/