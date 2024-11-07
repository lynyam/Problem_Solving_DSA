class Solution {
    public int waysToSplitArray(int[] nums) {
        long prefix = 0;
        int i = 0;
        int n = nums.length;
        long curr = 0;
        int ans = 0;

        while (i < n) {
            prefix += nums[i++];
        }
        i = 0;
        while (i < n - 1) {
            curr += nums[i];
            ans += curr >= prefix - curr ? 1 : 0;
            i++;
        }
        return (ans); 
    }
}