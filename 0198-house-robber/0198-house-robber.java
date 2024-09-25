class Solution {
    public int rob(int[] nums) {
        int backOne = nums[0];
        int n = nums.length;
        if (n > 1)
            backOne = Math.max(nums[0], nums[1]);
        int backTwo = nums[0];

        int i = 2;
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
    - constaint: broken 2 adj house into same nigth
    - nums = amount of each house
    - ret max amount of money you can rob tonight

    Soolution
    - decision to rob each house make impact on hour next choice, you need max, I think we can use DP
    - return value is max amount on fonction Fn(state) with state is i index of home u rob
    - think about recuresion formula: Fn(i) = Max(F(i - 1), F(i - 2) + nums(i))
    - base case: Fn(1) = nums[0] F(2) = max(nums[1], nums[2]) 
    1
    2
    2//4 =>4
    4


 */