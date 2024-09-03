class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> store = new HashMap<>();
        int curr = 0;
        store.put(0, 1);
        int ans = 0;

        for (int num : nums) {
            curr += num;
            ans += store.getOrDefault(curr - k, 0);
            store.put(curr, store.getOrDefault(curr, 0) + 1);
        }
        return (ans);
    }
}
/**
    - nums, intk
    - ret total sub sum = k
 */