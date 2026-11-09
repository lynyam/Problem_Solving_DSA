class Solution {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> counts = new HashMap<>();
        
        for (int num : arr) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        int result = -1;
        for (int key  : counts.keySet()) {
            if (key == counts.get(key))
                result = Math.max(result, key);
        }
        return (result);
    }
}