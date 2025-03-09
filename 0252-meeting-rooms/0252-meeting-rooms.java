class Solution {
    /*public boolean canAttendMeetings(int[][] intervals) {
        int n = intervals.length;
        for (int i = 0; i < n; i++) {
            int startI = intervals[i][0];
            int endI = intervals[i][1];
            for (int j = i + 1; j < n; j++) {
                int startJ = intervals[j][0];
                int endJ = intervals[j][1];
                if ((startI <= startJ && startJ < endI) || (startJ <= startI && startI < endJ))
                    return (false);
            }
        }
        return (true);
        
    }*/

    public boolean canAttendMeetings(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] < intervals[i - 1][1])
                return (false);
        }
        return (true);
    }
}

/**
    [0 10] [5, x] 
    [5 10] [7 x]
    Input: intervals = [[0,30],[5,10],[15,20]]
Output: false

 */