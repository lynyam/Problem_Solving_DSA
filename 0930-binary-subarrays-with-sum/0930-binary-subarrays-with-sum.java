class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> prefixSum = new HashMap<>();
        int curr, result;
        result = curr = 0;
        prefixSum.put(0, 1);

        for (int num : nums) {
            curr += num;
            if (prefixSum.containsKey(curr - goal)) {
                result += prefixSum.get(curr - goal);
            }
            prefixSum.put(curr, prefixSum.getOrDefault(curr, 0) + 1);
        }
        return (result);
    }
}