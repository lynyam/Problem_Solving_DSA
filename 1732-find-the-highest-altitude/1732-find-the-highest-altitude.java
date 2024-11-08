class Solution {
    public int largestAltitude(int[] gain) {
        int i = 1;
        int sum = gain[0];
        int ans = gain[0];

        while (i < gain.length) {
            sum += gain[i++];
            ans = Math.max(ans, sum);
        }
        return (ans < 0 ? 0 : ans);
    }
}