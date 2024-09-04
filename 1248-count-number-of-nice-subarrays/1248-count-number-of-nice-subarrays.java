class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int ans = 0;
        HashMap<Integer, Integer> store = new HashMap<>();
        store.put(0, 1);
        int n = nums.length;
        int i = 0;
        int curr = 0;

        while (i < n) {
            curr += nums[i] % 2 == 0 ? 0 : 1;
            ans += store.getOrDefault(curr - k, 0);
            store.put(curr, store.getOrDefault(curr, 0) + 1);
            i++;
        } 
        return (ans);
    }
}
/**
    - nums[] k
    - subArray k odd number
    - ret number. of nice sub
 */