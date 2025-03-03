class Solution {
	public int maximumGap(int[] nums) {
        int n = nums.length;
        if (n < 2) return (0);
		int max = Integer.MIN_VALUE;
		for (int num : nums) {
			max = Math.max(max, num);
        }
        int digitCount = 0;
        while (max > 0) {
            max /= 10;
            digitCount++;
        }
        
        int dec = 1;


        for (int i = 0; i < digitCount; i++) {
            List<Integer>[] bucket = new ArrayList[10];
            for (int num : nums) {
                int digit;
                if (i == 0) {
                    digit = num % 10;
                } else {
                    digit = (num / dec) % 10;
                }
                if (bucket[digit] == null)
                    bucket[digit] = new ArrayList<Integer>();
                bucket[digit].add(num);
            }
            int j = 0;
            for (List<Integer> temp : bucket) {
                if (temp == null) continue ;
                for (int number : temp) {
                    nums[j] = number;
                    j++;
                }
            }
            dec *= 10;
        }
        int result = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            result = Math.max(result, nums[i] - nums[i - 1]);
        }
        return (result);
    }
}
