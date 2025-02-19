class Solution {
	int waysToSplitArray(int[] nums) {
		int n = nums.length;
        double prefix = nums[0];
        double curr = 0;
		int i = 1;
		int answer = 0;

		while (i < n) {
			prefix += (double)nums[i];//  3 5 8 10
			i++;
		}
		i = 0;
		while (i < n - 1) {
            curr += nums[i];
			if (curr >= prefix - curr)//5 ==5
				answer++;
			i++;
		}
		return (answer);
    }
}
