class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int backOne = 0;
        int i = 2;
        if (n == 1)
            return (nums[0]);
        if (n >= 2)
            backOne = Math.max(nums[0], nums[1]);
        int backTwo = nums[0];
        while (i < n) {
            int temp = backOne;
            backOne = Math.max(backOne, backTwo + nums[i]);
            backTwo = temp;
            i++;
        }
        return (backOne);
    }
}

/**
Bottom-Up non optimiser
class Solution {
    int [] dp;
    public int rob(int[] nums) {
        int n = nums.length;
        dp = new int[n];
        int i = 0;
        while (i < n) {
            if (i == 0)
                dp[i] = nums[0];
            else if (i == 1)
                dp[i] = Math.max(nums[0], nums[1]);
            else {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            }
            i++;
        }
        return (dp[n - 1]);
    }
}
*/

/** 
Top - down
class Solution {
    HashMap<Integer, Integer> memo;
    public int rob(int[] nums) {
        memo = new HashMap<>();
        if (nums.length == 0)
            return (0);
        return (dp(nums.length - 1, nums));
    }

    public int dp(int i, int[] nums) {
        if (i == 0)
            return (nums[0]);
        if (i == 1)
            return (Math.max(nums[0], nums[1]));
        if (memo.containsKey(i))
            return (memo.get(i));
        memo.put(i, Math.max(dp(i - 1, nums), dp(i - 2, nums) + nums[i]));
        return (memo.get(i));
    }
}*/
/**
    - two adj houses were broken into on the same night
    - nums[i] amount of money of each house
    - ret max amount of money you can ron tonight without aleting police

    Solution
    - return max amount of money Fn(State) state = i [0, n-1] house
    - Function : Fn(n) = max(F(n-1), F(n-2) + nums[n])
    - base case: F(0) = nums[0], F(1) = max(nums[0], nums[1])
 */