class Solution {
    public int largestUniqueNumber(int[] nums) {
        HashMap<Integer, Integer> store = new HashMap<>();

        for (int num : nums) {
            store.put(num, store.getOrDefault(num, 0) + 1);
        }
        int ans = Integer.MIN_VALUE;
        for (int key : store.keySet()) {
            if (store.get(key).equals(1))
                ans = Math.max(ans, key);
        }
        return (ans == Integer.MIN_VALUE ? -1 : ans);
    }
}
/**
    - nums[]
    - ret largest int that only occur once
    - or -1 if not
 */