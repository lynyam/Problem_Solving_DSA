class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int min = intervals[0][0];
        int max = intervals[0][1];
        for (int i = 1; i < n; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            if (start <= max) {
                max = Math.max(max, end);
            } else {
                result.add(new int[]{min, max});
                min = start;
                max = end;
            }
        }
        result.add(new int[]{min, max});
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
        Input: intervals = [[1,3],[2,6],[8,10],[15,18]] => 
        Output: [[1,6],[8,10],[15,18]]
 */