class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int i = 0;
        int max = 0;
        for (int[] trip : trips) {
            max = Math.max(max, trip[2]);
        }
        int[] intervalls = new int[max + 1];
        for (int[] trip : trips) {
            intervalls[trip[1]] += trip[0];
            intervalls[trip[2]] -= trip[0];
        }
        int ans = 0;
        for (int position : intervalls) {
            ans += position;
            if (ans > capacity)
                return (false);
        }
        return (true);
    }
}