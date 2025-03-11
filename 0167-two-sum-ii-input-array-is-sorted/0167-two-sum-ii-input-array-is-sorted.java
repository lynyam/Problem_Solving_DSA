class Solution {
	public int[] twoSum(int[] nums, int target) {
		int n = nums.length;
		// define 2 pointeur
		int left = 0;
		int right = n - 1;


		while (left < right) {
			int sum = nums[left] + nums[right];
			if (sum == target) {
				return (new int[]{left + 1, right + 1});
            }
            if (sum < target)
                left++;
            else
                right--;
        }
        return (new int[0]);
    }
}


