class Solution {
    public int rob(int[] nums) {
        int one = 0;
        int two = 0;
        int n = nums.length;
        int i = 0;
        
        while (i < n) {
            if (i == 0)
                one = nums[0];
            if (i == 1) {
                one = Math.max(one, nums[1]);
                two = nums[0];
            }
            else {
                int temp = one;
                one = Math.max(one, two + nums[i]);
                two = temp;
            }
            i++;
        }
        return (one);
    }
}