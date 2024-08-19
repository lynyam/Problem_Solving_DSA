class Solution {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        double sum = 0;

        for (int s : sticks) {
            heap.add(s);
        }
        while (heap.size() > 1) {
            int min1 = heap.remove();
            int min2 = heap.remove();
            sum += min1 + min2;
            heap.add(min1 + min2);
        }
        return ((int)sum);
        
    }
}
/*
    - sticks double[]
        - sticks[i] > 0, length of ith stick
        - can connect x et y => x+y cost
    - connect all the stick until one stick remaining
    - minimum cost of connecting all to one 
*/