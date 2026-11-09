class Solution {
    public int numIdenticalPairs(int[] nums) {
        //i'll use HM because we can have duplicate paire 
        int result = 0;
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            int curr = counts.getOrDefault(num, 0);
            result += curr;
            counts.put(num, curr + 1);
        }
        return (result);
    }
}