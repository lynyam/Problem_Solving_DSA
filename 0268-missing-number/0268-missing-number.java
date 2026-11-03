class Solution {
    public int missingNumber1(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return (n * (n + 1) / 2) - sum;
    }

    public int missingNumber(int[] nums) {
        int n = nums.length;
        int i = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        while (i <= n) {
            if (!set.contains(i))
                return (i);
            i++;
        }
        return 0;
    }
}