class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer, Integer> store = new HashMap<>();
        int left = 0;
        int right = 0;
        int n = nums.length;
        int ans = 0;

        while (right < n) {
            int num = nums[right];
            store.put(num, store.getOrDefault(num, 0) + 1);
            while (store.getOrDefault(num, 0) > k) {
                store.put(nums[left], store.getOrDefault(nums[left], 0) - 1);
                left++;
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return (ans);
    }
}