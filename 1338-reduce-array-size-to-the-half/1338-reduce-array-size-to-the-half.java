class Solution {
    public int minSetSize(int[] arr) {
        HashMap<Integer, Integer> store = new HashMap<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> store.get(b) - store.get(a));
        int ans = 0;

        for (int num : arr) {
            store.put(num, store.getOrDefault(num, 0) + 1);
        }
        for (int key : store.keySet()) {
            heap.add(key);
        }
        int half = 0;
        while (half < arr.length / 2) {
            half += store.get(heap.remove());
            ans++;
        }
        return (ans);
    }
}
/**
    - arr[]
    - choose set of int and  remove all occ of thses int in arr
    - ret mini size of the set so that at leat half of the int of arry are removed
 */