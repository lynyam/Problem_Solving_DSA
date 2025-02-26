
class Solution {// 1 1 1 1 => 1 2 3 4
	public int[]	runningSum(int[] nums) {
		int n = nums.length;
        int[] prefix = new int[n];
        if (n == 0) return (new int[0]);


        prefix[0] = nums[0];//[1 0 0 0]
        int i = 1;
        while (i < n) {
	        prefix[i] = prefix[i - 1] + nums[i];////[1 2 3 4]
	        i++;
        }
        return (prefix);
	}
}
