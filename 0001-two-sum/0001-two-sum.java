class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> store = new HashMap<>();
        int i = 0;
        int n = nums.length;

        while (i < n) {
            if (store.containsKey(nums[i])) {
                return (new int[] {i, store.get(nums[i])});
            }
            store.put(target - nums[i], i);
            i++;
        }
        return (new int[]{});
    }
}