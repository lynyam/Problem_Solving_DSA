class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> store = new HashMap<>();
        int[] ans = new int[k];
        PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> (store.get(n1) -
         store.get(n2)));
        int i = 0;

        for (int num : nums) {
            store.put(num, store.getOrDefault(num, 0) + 1);
        }
        for (int n : store.keySet()) {
            heap.add(n);
            if (heap.size() > k)
                heap.remove();
        }
        while (!heap.isEmpty()) {
            ans[i++] = heap.remove();
        }
        return (ans);
    }
}