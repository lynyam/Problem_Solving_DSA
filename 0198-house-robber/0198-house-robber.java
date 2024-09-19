class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int backOne = 0;
        int backTwo = 0;
        int i = 0;

        while (i < n) {
            if (i == 0)
                backOne = nums[0];
            if (i == 1) {
                backTwo = nums[0];
                backOne = Math.max(nums[0], nums[1]); 
            }
            else {
                int temp = backOne;
                backOne = Math.max(backOne, backTwo + nums[i]);
                backTwo = temp;
            }
            i++;
        }
        return (backOne);
    }
}


/**class Solution {
    HashMap<Integer, Integer> memo;
    public int rob(int[] nums) {
        memo = new HashMap<>();
        return(dp(nums.length - 1, nums));
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
    - rob 2 adj house call possible
    - nums[] amount of money of each house.
    - ret max amount of money u can rob tonight without alerting police
    Solution
    - return max amouth of money Fn (state) index i
    - recursion formula: Fn(n) = max(F(n-1), F(n-2) + nums[n])
    - base case :
        1 home => Fn(0) = nums[0]
        2 home => Fn(1) = max(nums[0], nums[1])
    

 */