class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int n = nums.length;
        int m = queries.length;
        int[] prefix = new int[n];
        int i = 1;
        int[] ans = new int[m];

        prefix[0] = nums[0];
        while (i < n) {
            prefix[i] = prefix[i - 1] + nums[i];
            i++;
        }
        i = 0;
        while (i < m) {
            int left = 0;
            int right = n - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (prefix[mid] > queries[i])
                    right = mid - 1;
                else
                    left = mid + 1;
            }
            ans[i] = left;
            i++;
        }
        return (ans);
    }
}
/**
    - nums [n]
    - queries[m]
    - ret ans[m] 
        - ans[i] = max(Subseq(nums)) / sum() <= queries[i]
 */