class Solution {
    public int minStartValue(int[] nums) {
        int result = Integer.MAX_VALUE;
        int curr = 0;
        for (int num : nums) {
            curr += num;
            result = Math.min(result, curr);
        }
        if (result >= 0) return (1);
        return 1 - result;
    }
}