class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> store = new HashMap<>();
        int i = 0;
        int n = nums.length;
        store.put(0, -1);
        int curr = 0;
        int ans = 0;

        while (i < n) {
            curr += nums[i] == 0 ? -1 : 1;
            if (store.containsKey(curr)) {
                ans = Math.max(ans, i - store.get(curr));
            }
            else
                store.put(curr, i);
            i++;
        }
        return (ans);
    }
}