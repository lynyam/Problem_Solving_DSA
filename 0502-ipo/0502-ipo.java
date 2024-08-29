class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int i = 0;
        int n = capital.length;
        long finalCap = w;
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        int[][] projects = new int[n][2];

        while (i < n) {
            projects[i] = new int[]{profits[i], capital[i]};
            i++;
        }
        Arrays.sort(projects, (a, b) -> (a[1] - b[1]));
        i = 0;
        while (k > 0) {
            while (i < n) {
                if (finalCap < projects[i][1]) {
                    break ;
                }
                heap.add(projects[i][0]);
                i++;
            }
            if (heap.isEmpty())
                return ((int)finalCap);
            finalCap += heap.remove();
            k--;
        }
        return ((int)finalCap);
    }
}
/**
    - finish <= k projet
    - maximise total capital after k project
    - capital[i]->projects[i]
    - w capital
 */