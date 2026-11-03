class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer, Integer> store = new HashMap<>(n);
        int i = 0;

        while (i < n) {
            int num = nums[i];
            if (store.containsKey(num)) {
                return new int[]{store.get(num), i};
            }
            store.put(target - num, i);
            i++;
        }
        return new int[]{0};
    }
}