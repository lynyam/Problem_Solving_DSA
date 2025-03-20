class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        if (n == 0) return (new int[][] {newInterval});
        int min = newInterval[0];
        int max = newInterval[1];
        int currStart;
        int currEnd;
        List<int[]> result = new ArrayList<>();
        int i = 0;
        while (i < n) {
            currStart = intervals[i][0];
            currEnd = intervals[i][1];
            if (currEnd < newInterval[0])
                result.add(intervals[i]);
            else {
                //min = Math.min(newInterval[0], currStart);
                //max = Math.max(newInterval[1], currEnd);
                break;
            }
            i++;
        }
        while (i < n) {
            currStart = intervals[i][0];
            currEnd = intervals[i][1];
            if (currStart <= max) {
                min = Math.min(min, currStart);
                max = Math.max(max, currEnd);
            } else {
                result.add(new int[]{min, max});
                min = currStart;
                max = currEnd;
            }
            i++;
        }
        result.add(new int[]{min, max});
        return (result.toArray(new int[result.size()][]));
    }
}
/*       [     ]
    [  ]

*/