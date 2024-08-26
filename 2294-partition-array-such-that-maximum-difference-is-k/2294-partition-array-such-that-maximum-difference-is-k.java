class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0;
        int n = nums.length;
        int ans = 0;

        while (i < n) {
            int min = nums[i];
            i++;
            ans++;
            while (i < n) {
                if (nums[i] > k + min) {
                    break ;
                }
                i++;
            }
        }
        return (ans);
    }
}
/**
    - nums int[]
    - int k
    - partition nums into one or more subsequence
        - each element in nums appears in exactly one of the subsequence
    - ret minimum number of subsequence needed
        - difference btw the max and min val in each subseq is at most k
    - Subsequence is a sequence than can be
        - derived from another seq by deleting some or no elts without changing the order of remaining elts
    - ex: nums = [3,6,1,2,5], k = 2 => 2

 */