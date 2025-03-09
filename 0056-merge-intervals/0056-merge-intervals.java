class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        boolean[] visited = new boolean[n];
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            int min = intervals[i][0];
            int max = intervals[i][1];
            for (int j = 0; j < n; j++) {
                if (visited[j] == true) continue;
                int start = intervals[j][0];
                int end = intervals[j][1];
                if (max < start || end < min) continue;
                visited[j] = true;
                min = Math.min(min, start);
                max = Math.max(max, end);
            }
            result.add(new int[]{min, max});
        }
        int[][] arr = new int[result.size()][];
        int k = 0;
        for (int[] interval : result) {
            arr[k] = interval;
            k++;
        }
        return (arr);
    }
}
/**
    [1 3] [2 6]
    [1 3] 
   [0 2]

   
   [0 2] [3 6] 
   [1 6] [0 2]
   [4 5] [2 3]
        Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
        Output: [[1,6],[8,10],[15,18]]
 */