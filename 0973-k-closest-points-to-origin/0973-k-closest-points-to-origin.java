class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> (b[0] * b[0]) + (b[1] * b[1]) - (a[0] * a[0]) - (a[1] * a[1]));
        int[][] ans = new int[k][2];
        int i = 0;

        for (int[] point : points) {
            heap.add(point);
            if (heap.size() > k) {
                heap.remove();
            }
        }
        while (!heap.isEmpty()) {
            ans[i] = heap.remove();
            i++;
        }
        return (ans);
    }
}
/**
    - points[i] = [xi, yi], int k
    - return k closest point to (0, 0)
    - dist = x2 + y2
 */