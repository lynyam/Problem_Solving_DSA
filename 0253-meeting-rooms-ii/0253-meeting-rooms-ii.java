class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int max = 0;
        for (int[] interval : intervals) {
            max = Math.max(max, interval[1]);
        }
        int[] timelines = new int[max + 1];
        for (int[] interval : intervals) {
            timelines[interval[0]] += 1;
            timelines[interval[1]] -= 1;
        }
        int answer = 0;
        int curr = 0;
        for (int meeting : timelines) {
            curr += meeting;
            answer = Math.max(answer, curr);
        }
        return (answer);
    }
}