class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[][] projects = new int[n][2];
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        int max = w;
        int i = 0;

        while (i < n) {
            projects[i] = new int[]{capital[i], profits[i]};
            i++;
        }
        Arrays.sort(projects, (a, b) -> Integer.compare(a[0], b[0]));
        if (w < projects[0][0])
            return (w);
        i = 0;
        while (i < n) {
            if (projects[i][0] > max && !heap.isEmpty() && k > 0) {
                max += heap.remove();
                k--;
            }
            if ((projects[i][0] > max && heap.isEmpty()) || k <= 0)
                return (max) ;
            if (projects[i][0] > max)
                continue ;
            heap.add(projects[i][1]);
            i++;
        }
        while (!heap.isEmpty() && k > 0) {
            max += heap.remove();
            k--;
        }
        /*int ptr = 0;
        for (int j = 0; j < k; j++) {
            while (ptr < n && projects[ptr][0] <= max) {
                heap.add(projects[ptr++][1]);
            }
            if (heap.isEmpty()) {
                return (max);
            }
            max += heap.poll();
        }*/
        return (max);
    }
}

/**
    - IPO leetcode
    - desire to work on some projects
    - it can finish <= k projects
    - best way to maximize after finish <= k projects
    - given n projects,
        - ith project => profits[i] => capital[i] to start
        - Init = w capital, after projet capital = w + profit[i]
    - pick <= k dstinct projets to max final capital
    - ret: final maximized capital
    - ans fit in int
    k = 2, w = 0, profits = [2,3,10], capital = [0,1,2]
    =>0 1 => 2+3 = 5 min capital <= currCap
    =>0 2 => 2+10 = 12 capital <= currCap with max profit
    - init : [0, maxIndex <= cap0] => choose Max profit[[0, maxIndex <= cap0]]
        - range min, range max <= capital ? DSA
            - 0 1 2 3 4
            - x x x x x 
 */
