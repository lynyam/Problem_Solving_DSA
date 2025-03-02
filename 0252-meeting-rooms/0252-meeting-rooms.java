class Solution {
	public boolean canAttendMeetings(int[][] intervals) {
		int max = 0;
		int min = 0;
		for (int[] meeting : intervals) {//0(n) time
			max = Math.max(max, meeting[1]);
			min = Math.min(min, meeting[0]);
        }
        int[] diff = new int[max + 1];//0(max) space
        for (int[] m : intervals) {//0(n) 
            diff[m[0]] += 1;
            diff[m[1]] -= 1;
        }
        int curr = 0;
        for (int i = min; i <= max; i++) {//0(max - min) time
            curr += diff[i];
            if (curr > 1)
                return (false);
        }
        return (true);
    }
}
