class Solution {
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length <= 1) return (nums);
        int n = nums.length;
        int max = nums[0];
        int min = nums[0];
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        int shift = -min;
        int[] counting = new int[max - min + 1];
        for (int num : nums) {
            counting[num + shift] += 1;
        }
        int[] result = new int[n];
        int k = 0;
        for (int i = 0; i < max - min + 1; i++) {
            if (counting[i] == 0) continue;
            for (int j = 0; j < counting[i]; j++) {
                result[k++] = i - shift;
            }
        }
        return (result);

    }
}