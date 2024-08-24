class Solution {//klogn + nlogn = (n + k)logn
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> store = new HashMap<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> store.get(a) - store.get(b));

        for (int num : arr) {
            store.put(num, store.getOrDefault(num, 0) + 1);
        }
        for (int key : store.keySet()) {
            heap.add(key);
        }
        int i = 0;
        while (k > 0) {
            int min = heap.remove();
            int freq = store.get(min);
            if (freq <= k) {
                k -= freq;
                store.remove(min);
            }
            else {
                heap.add(min);
                break ;
            }
        }
        return (heap.size());
    }
}
/**
    - arr int[]
    - int k
    - find least number of unique integer, after removing k elts
    - ex: 
        [5,5,4] k = 1
        1
 */