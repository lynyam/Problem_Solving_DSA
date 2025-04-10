class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        for (int i = 1; i < intervals.length; i++) {
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];
            int cmpStart = intervals[i - 1][0];
            int cmpEnd = intervals[i - 1][1];
            if (currStart >= cmpStart && currStart < cmpEnd) return false;
        }
        return (true);
    }
}