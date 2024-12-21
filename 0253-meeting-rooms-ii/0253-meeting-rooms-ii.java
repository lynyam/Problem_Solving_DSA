class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int max = 0;
        for (int[] interval : intervals)
            max = Math.max(max, interval[1]);
        int[] diff = new int[max + 1];
        int ans = 0;
        for (int[] interval : intervals) {
            diff[interval[0]] += 1;
            diff[interval[1]] -= 1;
        }
        int curr = 0;
        int i = 0;
        while (i <= max) {
            curr += diff[i];
            ans = Math.max(ans, curr);
            i++;
        }
        return (ans);
    }
}