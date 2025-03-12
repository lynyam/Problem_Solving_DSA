class Solution {
	public int numSubarrayProductLessThanK(int[] nums, int k){
        if (k == 0) return (0);
		int n = nums.length;
		int left = 0;
		int right = 0;
		int curr = 1;
        int result = 0;
	
		while (right < n) {
			curr *= nums[right];
			while (curr >= k) {
				curr /= nums[left];
				left++;
            }
            result += (right - left + 1);
            right++;
        }
        return (result);
    }
}
