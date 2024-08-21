class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((p1, p2) -> {
            return ((p2[0] * p2[0]) + (p2[1] * p2[1]) - ((p1[0] * p1[0]) + (p1[1] * p1[1])));});

        for (int[] p : points) {
            heap.add(p);
            if (heap.size() > k) {
                heap.remove();
            }
        }
        int[][] ans = new int[k][2];
        int i = 0;
        while (!heap.isEmpty()) {
            ans[i++] = heap.remove();
        }
        return (ans);
    }
}
/**
    - points int[][]
        - points[i] = [xi, yi] a point on the X-Y plane
        - int k, 
        - ret k closest points to (0, 0)
        - dist btw 2 point (x1-x2)2 + (y1-y2)2
        - ret ans in any order
 */