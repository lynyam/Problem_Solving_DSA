class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> store = new HashMap<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> store.get(a) - store.get(b));

        for (int num : arr) {
            store.put(num, store.getOrDefault(num, 0) + 1);
        }
        for (int num : arr) {
            heap.add(num);
        }
        while (k > 0) {
            int num = heap.remove();
            int freq = store.get(num);
            if (freq <= k) {
                k -= freq;
                store.remove(num);
            } else {
                break ;
            }
        }
        return (store.size());
    }
}
/**
    - arr[n]
    - int k
    - find the least number of unique int / after removing exactly k elt
 */