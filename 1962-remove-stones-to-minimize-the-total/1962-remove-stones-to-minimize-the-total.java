class Solution {
    public int minStoneSum(int[] piles, int k) {
        double sum = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int p : piles) {
            heap.add(p);
            sum += p;
        }
        while (!heap.isEmpty() && k > 0) {
            int curr = heap.remove();
            sum -= curr / 2;
            heap.add(curr - curr / 2);
            k--;
        }
        return ((int)sum);
        
    }
}
/**
    - piles int[]
        - piles[i] = number of stones ith pile
    - k int
    - apply ope:
        - choose piles[i]
        - remove floor(piles[i]/2) stones from it
        - apply ope recursivly
    - ret: minimum possible total number of stones remaining after k ope
    - floor(x) = greatest int that is smaller than or equal to x
        - round x down
 */