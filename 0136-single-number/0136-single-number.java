class Solution {
    public int singleNumber(int[] nums) {
        // 0 ^ x = x
        // x ^ x ^ y = 0 ^ y = y
        // if one sigle number and other twice => 0 ^ each num = sigle num
        // bcse num1 ^ 0 ^ num1 ^ num2 ^ num2 ^ num3 = 0 ^ num3 = num3

        int mask = 0;
        for (int num : nums) {
            mask ^= num;
        }
        return (mask);
    }
}