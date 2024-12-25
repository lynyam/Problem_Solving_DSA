class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int end = 0;
        for (int[] trip : trips)
            end = Math.max(end, trip[2]);
        int[] diff = new int[end + 1];

        for (int[] trip : trips) {
            diff[trip[1]] += trip[0];
            diff[trip[2]] -= trip[0];
        }
        int curr = 0;
        for (int location : diff) {
            curr += location;
            if (curr > capacity)
                return (false);
        }
        return (true);
    }
}