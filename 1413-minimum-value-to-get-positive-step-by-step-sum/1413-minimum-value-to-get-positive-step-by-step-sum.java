class Solution {
	public int minStartValue(int[] nums) {
		int ans = 1;
		int curr = 0;
		for (int i = 0; i < nums.length; i++) {
			curr += nums[i];//1
			if (curr <= 0);
                ans = Math.max(ans, 1 - curr);//5
        }
        return (ans);
    }
}