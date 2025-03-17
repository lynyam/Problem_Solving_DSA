class Solution {
    public int minMeetingRooms(int[][] intervals) {
	int maxEnd = 0;
	int minStart = 0;
	
	for (int[] interval : intervals) {//0(N)
		maxEnd = Math.max(maxEnd, interval[1]);
		minStart = Math.min(minStart, interval[0]);
    }
    int[] diff = new int[maxEnd + 1];//0(M)
    for (int[] meeting : intervals) {//0(N)
        diff[meeting[0]] += 1;
        diff[meeting[1]] -= 1;
    }
    int curr = 0;
    int result = 0;
    for (int i = minStart; i <= maxEnd; i++) {//0(M)
        diff[i] += curr;
        curr = diff[i];
        result = Math.max(result, curr);
    }
        return(result);
    }
}