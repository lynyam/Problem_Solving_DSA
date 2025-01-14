class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int maxpos = 0;
        for (int[] interval : intervals) {
            maxpos = Math.max(maxpos, interval[1]);
        }
        int[] arr = new int[maxpos + 1];
        for (int[] interval : intervals) {
            arr[interval[0]] += 1;
            arr[interval[1]] -= 1;
        }
        int ans = 0;
        int curr = 0;
        for (int time : arr) {
            curr += time;
            ans = Math.max(ans, curr);
        }
        return (ans);
    }
}