class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((p1, p2) -> ((p2[0] * p2[0] + p2[1] * p2[1]) - (p1[0] * p1[0] + p1[1] * p1[1])));
        
        for (int[] p : points) {
            heap.add(p);
            if (heap.size() > k) {
                heap.remove();
            }
        }
        int i = 0;
        int[][] ans = new int[k][2];
        while (!heap.isEmpty()) {
            ans[i++] = heap.remove();
        }
        return (ans);
    }
}
/**
    - points[i]= [xi, yi] int[][] point on X-Y
    - integer k
    - ret : k closest points to origin (0,0)
    - distance btw 2 point X-Y plane = racine(x1-x2)2 + (y1 - y2)2)
    - 
 */