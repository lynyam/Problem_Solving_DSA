class Solution {
    public int minStoneSum(int[] piles, int k) {
        int sum = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());

        for (int stones : piles) {
            heap.add(stones);
            sum += stones;
        }
        while (k > 0) {
            int stones = heap.remove();
            int remove = stones / 2;
            sum -= remove;
            heap.add(stones - remove);
            k--;
        }
        return (sum);
    }
}
/**
    - piles int[]
        - piless[i] = nbr of stone in ith pile
    - int k
    - apply operation k times
        - choose piles[i] remove floor(piles[i] / 2) stone from it
        - apply more and more
    - ret : min possible total of stones after k ope
    - floor(x) is greatest int that is <= x
 */