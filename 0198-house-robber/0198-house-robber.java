class Solution {
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
}
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