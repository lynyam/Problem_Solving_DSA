class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());

        for (int stone : stones) {
            heap.add(stone);
        }
        while (heap.size() > 1) {
            int y = heap.remove();
            int x = heap.remove();
            if (y > x) {
                heap.add(y - x);
            }
        }
        return (heap.isEmpty() ? 0 : heap.remove());
    }
}
/*
    - stones int[]
        - stones[i] = poids ieme pierres
    - each turn smatch max1(stones) x max2(stones) y 2 stones
        - x <= y
        - x == y destroyes x and y
        - x != y x is destroyed y = y - x
    - one stone left
    - ret weight of the last or 0 if not
*/