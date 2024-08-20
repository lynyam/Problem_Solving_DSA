class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> {
            if (Math.abs(n1 - x) - Math.abs(n2 - x) != 0)
                return (Math.abs(n2 - x) - Math.abs(n1 - x));
            else
                return (n2 - n1);   
        });

        for (int num : arr) {
            heap.add(num);
            if (heap.size() > k) {
                heap.remove();
            }
        }
        while (!heap.isEmpty()) {
            ans.add(heap.remove());
        }
        Collections.sort(ans);
        return (ans);
    }
}
/**
    - arr int[]
    - int k, int x
    - ret : k closest int to x in arr
        - a closest to x than b if 
            - |a - x| < |b - x| or
            - |a - x| == |b - x| and a < b
    - sorted in ascending order

 */