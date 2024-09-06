class Solution {
    public int splitArray(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int i = 0;

        for (int num : nums) {
            left = Math.max(left, num);
            right += num;
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (check(mid, nums, k))
                right = mid - 1;
            else
                left = mid + 1;
        }
        return (left);
    }

    public boolean check(int mid, int[] nums, int k) {
        int sum = 0;
        int ans = 0;

        for (int num : nums) {
            if (sum + num <= mid) {
                sum += num;
            }
            else {
                sum = num;
                ans++;
            }
        }
        return (ans + 1 <= k);
    }
}
/**
    - nums[], int k
    - split nums into k nn-empty sub/
        - largest sum d'1 sub soit minimiser
    - ret minimized largest sum
 */