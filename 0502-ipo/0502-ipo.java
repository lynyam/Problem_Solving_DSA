class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        //create new dsa to link profit-capital
        //sort based on capital
        // use maxHeap to have the maximum

        int n = profits.length;
        int[][] projects = new int[n][2];
        for (int i = 0; i < n; i++) {
            projects[i] = new int[] {capital[i], profits[i]};
        }
        Arrays.sort(projects, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        int i = 0;
        while (k > 0) {
            while (i < n && projects[i][0] <= w) {
                maxHeap.add(projects[i][1]);
                i++;
            }
            if (maxHeap.isEmpty()) return (w);
            w += maxHeap.poll();
            k--;
        }
        return (w);

    }
}