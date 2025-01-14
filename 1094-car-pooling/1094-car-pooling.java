class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int toMax = 0;
        for (int[] trip : trips) {
            toMax = Math.max(toMax, trip[2]);
        }
        int[] arr = new int[toMax + 1];
        for (int[] trip : trips) {
            arr[trip[1]] += trip[0];
            arr[trip[2]] -= trip[0];
        }
        int i = 1;
        while (i < arr.length) {
            if (arr[i - 1] > capacity)
                return (false);
            arr[i] += arr[i - 1];
            i++;
        }
        return (true);
    }
}