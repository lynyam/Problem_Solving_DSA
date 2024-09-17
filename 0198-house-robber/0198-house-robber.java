class Solution {
    //Bottom- up optimiser
    public int rob(int[] nums) {
        int n = nums.length;
        int backOne = nums[0];
        int backTwo = nums[0];

        int i = 0;
        while (i < n) {
            if (i == 1)
                backOne = Math.max(nums[0], nums[1]);
            if (i > 1) {
                int temp = backOne;
                backOne = Math.max(backOne, backTwo + nums[i]);
                backTwo = temp;
            }
            i++;
        }
        return (backOne);
    }
    /*
    //Bottom- up
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        int i = 0;
        while (i < n) {
            if (i == 0)
                dp[0] = nums[0];
            if (i == 1)
                dp[1] = Math.max(nums[0], nums[1]);
            if (i > 1) {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            }
            i++;
        }
        return (dp[n - 1]);
    }*/
}

/**class Solution {
    HashMap<Integer, Integer> memo;
    public int rob(int[] nums) {
        memo = new HashMap<>();
        return(dp(nums.length - 1, nums));
    }
    
    public int dp(int i, int[] nums) {
        if (i == 0)
            return (nums[i]);
        if (i == 1)
            return (Math.max(nums[0], nums[1]));
        if (memo.containsKey(i))
            return (memo.get(i));
        memo.put(i, Math.max(dp(i - 1, nums), dp(i - 2, nums) + nums[i]));
        return (memo.get(i));
    }
}*/
/**
 - nums[i] = amount of money of house i
 - contrains = adj houses have secu systems/ if two adj house brokeninto on same night
 - ret : max amount of money u can rob 1 night wiithout aleting police

 Solution 
 - Top - Down
    1- retun = max amount of money dp(State)/ state =>(index i d'une maison)
    2- recursif formula: F(n) = max (F(n-1), F(n-2) + nums[n])
    3- base case F(0) = nums[0] , F(1) = max(nums[0], nums[1])
 */