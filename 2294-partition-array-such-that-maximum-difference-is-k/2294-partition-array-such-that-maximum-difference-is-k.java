class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int right = 0;
        int n = nums.length;
        int ans = 0;

        while (right < n) {
            ans++;
            while (right < n && nums[right] - nums[left] <= k) {
                right++;
            }
            left = right;
        }
        return (ans);
    }
}
/**
    - nums[] , int k
    - partition nums into 1 0r more subsequence, each elt in nums appears one time
    - ret mini number of subseq/ diff(max, min val) <= k
    3-x <= 2 =>x >= 3-1
 */