class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0;
        int j = 0;
        int n = nums.length;

        while (j < n) {
            if (nums[j] != 0 && j >=i) {
                nums[i] = nums[j];
                if (j > i) nums[j] = 0;
                i++;
            }
            j++;
        }
    }
}