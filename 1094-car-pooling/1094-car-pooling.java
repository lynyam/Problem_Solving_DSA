class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int end = 0;
        for (int[] trip : trips) {
            end = Math.max(end, trip[2]);
        }
        int[] diff = new int[end + 2];
        for (int[] trip : trips) {
            diff[trip[1]] += trip[0];
            diff[trip[2]] -= trip[0];
        }
        int[] answer = new int[end + 1];
        int i = 1;
        answer[0] = diff[0];
        if (answer[0] > capacity)
                return (false);
        while (i <= end) {
            answer[i] = diff[i] + answer[i - 1];
            if (answer[i] > capacity)
                return (false);
            i++;
        }
        return (true);
    }
}