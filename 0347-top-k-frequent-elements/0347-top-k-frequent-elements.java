class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> frequency = new HashMap<>();
        
        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);//{1:3, 2:2, 3:1}
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b)-> frequency.get(a) - frequency.get(b));
        for (int num : frequency.keySet()) {
            maxHeap.add(num);//{3, 2, 1}
            if (maxHeap.size() > k) {
            maxHeap.poll();//{2, 1}
            }
        }
        int i = 0;
        int[] result = new int[k];
        while (!maxHeap.isEmpty()) {
            result[i++] = maxHeap.poll();
        }
        return (result);
    }

}